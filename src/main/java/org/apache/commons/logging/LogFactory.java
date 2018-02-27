/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 

package org.apache.commons.logging;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;




public abstract class LogFactory {


    public static final String PRIORITY_KEY = "priority";


    public static final String TCCL_KEY = "use_tccl";


    public static final String FACTORY_PROPERTY =
        "org.apache.commons.logging.LogFactory";

    public static final String FACTORY_DEFAULT =
        "org.apache.commons.logging.impl.LogFactoryImpl";


    public static final String FACTORY_PROPERTIES =
        "commons-logging.properties";


    protected static final String SERVICE_ID =
        "META-INF/services/org.apache.commons.logging.LogFactory";


    public static final String DIAGNOSTICS_DEST_PROPERTY =
        "org.apache.commons.logging.diagnostics.dest";


    private static PrintStream diagnosticsStream = null;
    

    private static String diagnosticPrefix;
    

    public static final String HASHTABLE_IMPLEMENTATION_PROPERTY =
        "org.apache.commons.logging.LogFactory.HashtableImpl";

    private static final String WEAK_HASHTABLE_CLASSNAME = 
        "org.apache.commons.logging.impl.WeakHashtable";


    private static ClassLoader thisClassLoader;
    
    // ----------------------------------------------------------- Constructors



    protected LogFactory() {
    }
    
    // --------------------------------------------------------- Public Methods



    public abstract Object getAttribute(String name);



    public abstract String[] getAttributeNames();



    public abstract Log getInstance(Class clazz)
        throws LogConfigurationException;



    public abstract Log getInstance(String name)
        throws LogConfigurationException;


    public abstract void release();



    public abstract void removeAttribute(String name);



    public abstract void setAttribute(String name, Object value);



    protected static Hashtable factories = null;
    

    protected static LogFactory nullClassLoaderFactory = null;


    private static final Hashtable createFactoryStore() {
        Hashtable result = null;
        String storeImplementationClass;
        try {
            storeImplementationClass = getSystemProperty(HASHTABLE_IMPLEMENTATION_PROPERTY, null);
        } catch(SecurityException ex) {
            // Permissions don't allow this to be accessed. Default to the "modern"
            // weak hashtable implementation if it is available.
            storeImplementationClass = null;
        }

        if (storeImplementationClass == null) {
            storeImplementationClass = WEAK_HASHTABLE_CLASSNAME;
        }
        try {
            Class implementationClass = Class.forName(storeImplementationClass);
            result = (Hashtable) implementationClass.newInstance();
            
        } catch (Throwable t) {
            // ignore
            if (!WEAK_HASHTABLE_CLASSNAME.equals(storeImplementationClass)) {
                // if the user's trying to set up a custom implementation, give a clue
                if (isDiagnosticsEnabled()) {
                    // use internal logging to issue the warning
                    logDiagnostic("[ERROR] LogFactory: Load of custom hashtable failed");
                } else {
                    // we *really* want this output, even if diagnostics weren't
                    // explicitly enabled by the user.
                    System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
                }
            }
        }
        if (result == null) {
            result = new Hashtable();
        }
        return result;
    }



    private static String trim(String src) {
    	if (src == null) {
    		return null;
    	}
    	return src.trim();
    }


    public static LogFactory getFactory() throws LogConfigurationException {
        // Identify the class loader we will be using
        ClassLoader contextClassLoader = getContextClassLoaderInternal();

        if (contextClassLoader == null) {
            // This is an odd enough situation to report about. This
            // output will be a nuisance on JDK1.1, as the system
            // classloader is null in that environment.
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Context classloader is null.");
            }
        }

        // Return any previously registered factory for this class loader
        LogFactory factory = getCachedFactory(contextClassLoader);
        if (factory != null) {
            return factory;
        }

        if (isDiagnosticsEnabled()) {
            logDiagnostic(
                    "[LOOKUP] LogFactory implementation requested for the first time for context classloader "
                    + objectId(contextClassLoader));
            logHierarchy("[LOOKUP] ", contextClassLoader);
        }

        // Load properties file.
        //
        // If the properties file exists, then its contents are used as
        // "attributes" on the LogFactory implementation class. One particular
        // property may also control which LogFactory concrete subclass is
        // used, but only if other discovery mechanisms fail..
        //
        // As the properties file (if it exists) will be used one way or 
        // another in the end we may as well look for it first.

        Properties props = getConfigurationFile(contextClassLoader, FACTORY_PROPERTIES);

        // Determine whether we will be using the thread context class loader to
        // load logging classes or not by checking the loaded properties file (if any).
        ClassLoader baseClassLoader = contextClassLoader;
        if (props != null) {
            String useTCCLStr = props.getProperty(TCCL_KEY);
            if (useTCCLStr != null) {
                // The Boolean.valueOf(useTCCLStr).booleanValue() formulation
                // is required for Java 1.2 compatability.
                if (Boolean.valueOf(useTCCLStr).booleanValue() == false) {
                    // Don't use current context classloader when locating any
                    // LogFactory or Log classes, just use the class that loaded
                    // this abstract class. When this class is deployed in a shared
                    // classpath of a container, it means webapps cannot deploy their
                    // own logging implementations. It also means that it is up to the
                    // implementation whether to load library-specific config files
                    // from the TCCL or not.
                    baseClassLoader = thisClassLoader; 
                }
            }
        }

        // Determine which concrete LogFactory subclass to use.
        // First, try a global system property
        if (isDiagnosticsEnabled()) {
            logDiagnostic(
                    "[LOOKUP] Looking for system property [" + FACTORY_PROPERTY 
                    + "] to define the LogFactory subclass to use...");
        }
        
        try {
            String factoryClass = getSystemProperty(FACTORY_PROPERTY, null);
            if (factoryClass != null) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                            "[LOOKUP] Creating an instance of LogFactory class '" + factoryClass
                            + "' as specified by system property " + FACTORY_PROPERTY);
                }
                
                factory = newFactory(factoryClass, baseClassLoader, contextClassLoader);
            } else {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                            "[LOOKUP] No system property [" + FACTORY_PROPERTY 
                            + "] defined.");
                }
            }
        } catch (SecurityException e) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "[LOOKUP] A security exception occurred while trying to create an"
                        + " instance of the custom factory class"
                        + ": [" + trim(e.getMessage())
                        + "]. Trying alternative implementations...");
            }
            ;  // ignore
        } catch(RuntimeException e) {
            // This is not consistent with the behaviour when a bad LogFactory class is
            // specified in a services file.
            //
            // One possible exception that can occur here is a ClassCastException when
            // the specified class wasn't castable to this LogFactory type.
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "[LOOKUP] An exception occurred while trying to create an"
                        + " instance of the custom factory class"
                        + ": [" + trim(e.getMessage())
                        + "] as specified by a system property.");
            }
            throw e;
        }


        // Second, try to find a service by using the JDK1.3 class
        // discovery mechanism, which involves putting a file with the name
        // of an interface class in the META-INF/services directory, where the
        // contents of the file is a single line specifying a concrete class 
        // that implements the desired interface.

        if (factory == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "[LOOKUP] Looking for a resource file of name [" + SERVICE_ID
                        + "] to define the LogFactory subclass to use...");
            }
            try {
                InputStream is = getResourceAsStream(contextClassLoader,
                                                     SERVICE_ID);

                if( is != null ) {
                    // This code is needed by EBCDIC and other strange systems.
                    // It's a fix for bugs reported in xerces
                    BufferedReader rd;
                    try {
                        rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    } catch (java.io.UnsupportedEncodingException e) {
                        rd = new BufferedReader(new InputStreamReader(is));
                    }

                    String factoryClassName = rd.readLine();
                    rd.close();

                    if (factoryClassName != null &&
                        ! "".equals(factoryClassName)) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "[LOOKUP]  Creating an instance of LogFactory class " + factoryClassName
                                    + " as specified by file '" + SERVICE_ID 
                                    + "' which was present in the path of the context"
                                    + " classloader.");
                        }
                        factory = newFactory(factoryClassName, baseClassLoader, contextClassLoader );
                    }
                } else {
                    // is == null
                    if (isDiagnosticsEnabled()) {
                        logDiagnostic(
                            "[LOOKUP] No resource file with name '" + SERVICE_ID
                            + "' found.");
                    }
                }
            } catch( Exception ex ) {
                // note: if the specified LogFactory class wasn't compatible with LogFactory
                // for some reason, a ClassCastException will be caught here, and attempts will
                // continue to find a compatible class.
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                        "[LOOKUP] A security exception occurred while trying to create an"
                        + " instance of the custom factory class"
                        + ": [" + trim(ex.getMessage())
                        + "]. Trying alternative implementations...");
                }
                ; // ignore
            }
        }


        // Third try looking into the properties file read earlier (if found)

        if (factory == null) {
            if (props != null) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                        "[LOOKUP] Looking in properties file for entry with key '" 
                        + FACTORY_PROPERTY
                        + "' to define the LogFactory subclass to use...");
                }
                String factoryClass = props.getProperty(FACTORY_PROPERTY);
                if (factoryClass != null) {
                    if (isDiagnosticsEnabled()) {
                        logDiagnostic(
                            "[LOOKUP] Properties file specifies LogFactory subclass '" 
                            + factoryClass + "'");
                    }
                    factory = newFactory(factoryClass, baseClassLoader, contextClassLoader);
                    
                    // TODO: think about whether we need to handle exceptions from newFactory
                } else {
                    if (isDiagnosticsEnabled()) {
                        logDiagnostic(
                            "[LOOKUP] Properties file has no entry specifying LogFactory subclass.");
                    }
                }
            } else {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                        "[LOOKUP] No properties file available to determine"
                        + " LogFactory subclass from..");
                }
            }
        }


        // Fourth, try the fallback implementation class

        if (factory == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                "[LOOKUP] Loading the default LogFactory implementation '" + FACTORY_DEFAULT
                + "' via the same classloader that loaded this LogFactory"
                + " class (ie not looking in the context classloader).");
            }
            
            // Note: unlike the above code which can try to load custom LogFactory
            // implementations via the TCCL, we don't try to load the default LogFactory
            // implementation via the context classloader because:
            // * that can cause problems (see comments in newFactory method)
            // * no-one should be customising the code of the default class
            // Yes, we do give up the ability for the child to ship a newer
            // version of the LogFactoryImpl class and have it used dynamically
            // by an old LogFactory class in the parent, but that isn't 
            // necessarily a good idea anyway.
            factory = newFactory(FACTORY_DEFAULT, thisClassLoader, contextClassLoader);
        }

        if (factory != null) {

            cacheFactory(contextClassLoader, factory);

            if( props!=null ) {
                Enumeration names = props.propertyNames();
                while (names.hasMoreElements()) {
                    String name = (String) names.nextElement();
                    String value = props.getProperty(name);
                    factory.setAttribute(name, value);
                }
            }
        }

        return factory;
    }



    public static Log getLog(Class clazz)
        throws LogConfigurationException {

        return (getFactory().getInstance(clazz));

    }



    public static Log getLog(String name)
        throws LogConfigurationException {

        return (getFactory().getInstance(name));

    }



    public static void release(ClassLoader classLoader) {

        if (isDiagnosticsEnabled()) {
            logDiagnostic("Releasing factory for classloader " + objectId(classLoader));
        }
        synchronized (factories) {
            if (classLoader == null) {
                if (nullClassLoaderFactory != null) {
                    nullClassLoaderFactory.release();
                    nullClassLoaderFactory = null;
                }
            } else {
                LogFactory factory = (LogFactory) factories.get(classLoader);
                if (factory != null) {
                    factory.release();
                    factories.remove(classLoader);
                }
            }
        }

    }



    public static void releaseAll() {

        if (isDiagnosticsEnabled()) {
            logDiagnostic("Releasing factory for all classloaders.");
        }
        synchronized (factories) {
            Enumeration elements = factories.elements();
            while (elements.hasMoreElements()) {
                LogFactory element = (LogFactory) elements.nextElement();
                element.release();
            }
            factories.clear();

            if (nullClassLoaderFactory != null) {
                nullClassLoaderFactory.release();
                nullClassLoaderFactory = null;
            }
        }

    }


    protected static ClassLoader getClassLoader(Class clazz) {
        try {
            return clazz.getClassLoader();
        } catch(SecurityException ex) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "Unable to get classloader for class '" + clazz
                        + "' due to security restrictions - " + ex.getMessage());
            }
            throw ex;
        }
    }


    protected static ClassLoader getContextClassLoader()
        throws LogConfigurationException {

        return directGetContextClassLoader();
    }


    private static ClassLoader getContextClassLoaderInternal()
    throws LogConfigurationException {
        return (ClassLoader)AccessController.doPrivileged(
            new PrivilegedAction() {
                public Object run() {
                    return directGetContextClassLoader();
                }
            });
    }


    protected static ClassLoader directGetContextClassLoader()
        throws LogConfigurationException
    {
        ClassLoader classLoader = null;

        try {
            // Are we running on a JDK 1.2 or later system?
            Method method = Thread.class.getMethod("getContextClassLoader", 
                    (Class[]) null);

            // Get the thread context class loader (if there is one)
            try {
                classLoader = (ClassLoader)method.invoke(Thread.currentThread(), 
                        (Object[]) null);
            } catch (IllegalAccessException e) {
                throw new LogConfigurationException
                    ("Unexpected IllegalAccessException", e);
            } catch (InvocationTargetException e) {

                if (e.getTargetException() instanceof SecurityException) {
                    ;  // ignore
                } else {
                    // Capture 'e.getTargetException()' exception for details
                    // alternate: log 'e.getTargetException()', and pass back 'e'.
                    throw new LogConfigurationException
                        ("Unexpected InvocationTargetException", e.getTargetException());
                }
            }
        } catch (NoSuchMethodException e) {
            // Assume we are running on JDK 1.1
            classLoader = getClassLoader(LogFactory.class);

            // We deliberately don't log a message here to outputStream;
            // this message would be output for every call to LogFactory.getLog()
            // when running on JDK1.1
            //
            // if (outputStream != null) {
            //    outputStream.println(
            //        "Method Thread.getContextClassLoader does not exist;"
            //         + " assuming this is JDK 1.1, and that the context"
            //         + " classloader is the same as the class that loaded"
            //         + " the concrete LogFactory class.");
            // }
            
        }

        // Return the selected class loader
        return classLoader;
    }


    private static LogFactory getCachedFactory(ClassLoader contextClassLoader)
    {
        LogFactory factory = null;

        if (contextClassLoader == null) {
            // We have to handle this specially, as factories is a Hashtable
            // and those don't accept null as a key value.
            //
            // nb: nullClassLoaderFactory might be null. That's ok.
            factory = nullClassLoaderFactory;
        } else {
            factory = (LogFactory) factories.get(contextClassLoader);
        }

        return factory;
    }

    private static void cacheFactory(ClassLoader classLoader, LogFactory factory)
    {
        // Ideally we would assert(factory != null) here. However reporting
        // errors from within a logging implementation is a little tricky!

        if (factory != null) {
            if (classLoader == null) {
                nullClassLoaderFactory = factory;
            } else {
                factories.put(classLoader, factory);
            }
        }
    }


    protected static LogFactory newFactory(final String factoryClass,
                                           final ClassLoader classLoader,
                                           final ClassLoader contextClassLoader)
        throws LogConfigurationException
    {
        // Note that any unchecked exceptions thrown by the createFactory
        // method will propagate out of this method; in particular a
        // ClassCastException can be thrown.
        Object result = AccessController.doPrivileged(
            new PrivilegedAction() {
                public Object run() {
                    return createFactory(factoryClass, classLoader);
                }
            });

        if (result instanceof LogConfigurationException) {
            LogConfigurationException ex = (LogConfigurationException) result;
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "An error occurred while loading the factory class:"
                        + ex.getMessage());
            }
            throw ex;
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic(
                    "Created object " + objectId(result)
                    + " to manage classloader " + objectId(contextClassLoader));
        }
        return (LogFactory)result;
    }


    protected static LogFactory newFactory(final String factoryClass,
                                           final ClassLoader classLoader) {
        return newFactory(factoryClass, classLoader, null);
    }


    protected static Object createFactory(String factoryClass, ClassLoader classLoader) {

        // This will be used to diagnose bad configurations
        // and allow a useful message to be sent to the user
        Class logFactoryClass = null;
        try {
            if (classLoader != null) {
                try {
                    // First the given class loader param (thread class loader)

                    // Warning: must typecast here & allow exception
                    // to be generated/caught & recast properly.
                    logFactoryClass = classLoader.loadClass(factoryClass);
                    if (LogFactory.class.isAssignableFrom(logFactoryClass)) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Loaded class " + logFactoryClass.getName()
                                    + " from classloader " + objectId(classLoader));
                        }
                    } else {
                        //
                        // This indicates a problem with the ClassLoader tree.
                        // An incompatible ClassLoader was used to load the 
                        // implementation. 
                        // As the same classes
                        // must be available in multiple class loaders,
                        // it is very likely that multiple JCL jars are present.
                        // The most likely fix for this
                        // problem is to remove the extra JCL jars from the 
                        // ClassLoader hierarchy. 
                        //
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Factory class " + logFactoryClass.getName()
                                + " loaded from classloader " + objectId(logFactoryClass.getClassLoader())
                                + " does not extend '" + LogFactory.class.getName()
                                + "' as loaded by this classloader.");
                            logHierarchy("[BAD CL TREE] ", classLoader);
                        }
                    }
                    
                    return (LogFactory) logFactoryClass.newInstance();

                } catch (ClassNotFoundException ex) {
                    if (classLoader == thisClassLoader) {
                        // Nothing more to try, onwards.
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Unable to locate any class called '" + factoryClass
                                    + "' via classloader " + objectId(classLoader));
                        }
                        throw ex;
                    }
                    // ignore exception, continue
                } catch (NoClassDefFoundError e) {
                    if (classLoader == thisClassLoader) {
                        // Nothing more to try, onwards.
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Class '" + factoryClass + "' cannot be loaded"
                                    + " via classloader " + objectId(classLoader)
                                    + " - it depends on some other class that cannot"
                                    + " be found.");
                        }
                        throw e;
                    }
                    // ignore exception, continue
                } catch(ClassCastException e) {
                    if (classLoader == thisClassLoader) {
                        // There's no point in falling through to the code below that
                        // tries again with thisClassLoader, because we've just tried
                        // loading with that loader (not the TCCL). Just throw an
                        // appropriate exception here.

                        final boolean implementsLogFactory = implementsLogFactory(logFactoryClass);
                        
                        //
                        // Construct a good message: users may not actual expect that a custom implementation 
                        // has been specified. Several well known containers use this mechanism to adapt JCL 
                        // to their native logging system. 
                        // 
                        String msg = 
                            "The application has specified that a custom LogFactory implementation should be used but " +
                            "Class '" + factoryClass + "' cannot be converted to '"
                            + LogFactory.class.getName() + "'. ";
                        if (implementsLogFactory) {
                            msg = msg + "The conflict is caused by the presence of multiple LogFactory classes in incompatible classloaders. " +
                                "Background can be found in http://commons.apache.org/logging/tech.html. " +
                                "If you have not explicitly specified a custom LogFactory then it is likely that " +
                                "the container has set one without your knowledge. " +
                                "In this case, consider using the commons-logging-adapters.jar file or " +
                                "specifying the standard LogFactory from the command line. ";
                        } else {
                            msg = msg + "Please check the custom implementation. ";
                        }
                        msg = msg + "Help can be found @http://commons.apache.org/logging/troubleshooting.html.";
                        
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(msg);
                        }
                        
                        ClassCastException ex = new ClassCastException(msg);
                        throw ex;
                    }
                    
                    // Ignore exception, continue. Presumably the classloader was the
                    // TCCL; the code below will try to load the class via thisClassLoader.
                    // This will handle the case where the original calling class is in
                    // a shared classpath but the TCCL has a copy of LogFactory and the
                    // specified LogFactory implementation; we will fall back to using the
                    // LogFactory implementation from the same classloader as this class.
                    //
                    // Issue: this doesn't handle the reverse case, where this LogFactory
                    // is in the webapp, and the specified LogFactory implementation is
                    // in a shared classpath. In that case:
                    // (a) the class really does implement LogFactory (bad log msg above)
                    // (b) the fallback code will result in exactly the same problem.
                }
            }

            /* At this point, either classLoader == null, OR
             * classLoader was unable to load factoryClass.
             *
             * In either case, we call Class.forName, which is equivalent
             * to LogFactory.class.getClassLoader().load(name), ie we ignore
             * the classloader parameter the caller passed, and fall back
             * to trying the classloader associated with this class. See the
             * javadoc for the newFactory method for more info on the 
             * consequences of this.
             *
             * Notes:
             * * LogFactory.class.getClassLoader() may return 'null'
             *   if LogFactory is loaded by the bootstrap classloader.
             */
            // Warning: must typecast here & allow exception
            // to be generated/caught & recast properly.
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                    "Unable to load factory class via classloader " 
                    + objectId(classLoader)
                    + " - trying the classloader associated with this LogFactory.");
            }
            logFactoryClass = Class.forName(factoryClass);
            return (LogFactory) logFactoryClass.newInstance();
        } catch (Exception e) {
            // Check to see if we've got a bad configuration
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Unable to create LogFactory instance.");
            }
            if (logFactoryClass != null
                && !LogFactory.class.isAssignableFrom(logFactoryClass)) {
                
                return new LogConfigurationException(
                    "The chosen LogFactory implementation does not extend LogFactory."
                    + " Please check your configuration.",
                    e);
            }
            return new LogConfigurationException(e);
        }
    }


    private static boolean implementsLogFactory(Class logFactoryClass) {
        boolean implementsLogFactory = false;
        if (logFactoryClass != null) {
            try {
                ClassLoader logFactoryClassLoader = logFactoryClass.getClassLoader();
                if (logFactoryClassLoader == null) {
                    logDiagnostic("[CUSTOM LOG FACTORY] was loaded by the boot classloader");
                } else {
                    logHierarchy("[CUSTOM LOG FACTORY] ", logFactoryClassLoader);
                    Class factoryFromCustomLoader
                        = Class.forName("org.apache.commons.logging.LogFactory", false, logFactoryClassLoader);
                    implementsLogFactory = factoryFromCustomLoader.isAssignableFrom(logFactoryClass);
                    if (implementsLogFactory) {
                        logDiagnostic("[CUSTOM LOG FACTORY] " + logFactoryClass.getName()
                                + " implements LogFactory but was loaded by an incompatible classloader.");
                    } else {
                        logDiagnostic("[CUSTOM LOG FACTORY] " + logFactoryClass.getName()
                                + " does not implement LogFactory.");
                    }
                }
            } catch (SecurityException e) {
                //
                // The application is running within a hostile security environment.
                // This will make it very hard to diagnose issues with JCL.
                // Consider running less securely whilst debugging this issue.
                //
                logDiagnostic("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether " +
                        "the compatibility was caused by a classloader conflict: "
                        + e.getMessage());
            } catch (LinkageError e) {
                //
                // This should be an unusual circumstance.
                // LinkageError's usually indicate that a dependent class has incompatibly changed.
                // Another possibility may be an exception thrown by an initializer.
                // Time for a clean rebuild?
                //
                logDiagnostic("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether " +
                        "the compatibility was caused by a classloader conflict: "
                        + e.getMessage());
            } catch (ClassNotFoundException e) {
                //
                // LogFactory cannot be loaded by the classloader which loaded the custom factory implementation.
                // The custom implementation is not viable until this is corrected.
                // Ensure that the JCL jar and the custom class are available from the same classloader.
                // Running with diagnostics on should give information about the classloaders used
                // to load the custom factory.
                //
                logDiagnostic("[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the " +
                        "custom LogFactory implementation. Is the custom factory in the right classloader?");
            }
        }
        return implementsLogFactory;
    }


    private static InputStream getResourceAsStream(final ClassLoader loader,
                                                   final String name)
    {
        return (InputStream)AccessController.doPrivileged(
            new PrivilegedAction() {
                public Object run() {
                    if (loader != null) {
                        return loader.getResourceAsStream(name);
                    } else {
                        return ClassLoader.getSystemResourceAsStream(name);
                    }
                }
            });
    }


    private static Enumeration getResources(final ClassLoader loader,
            final String name)
    {
        PrivilegedAction action = 
            new PrivilegedAction() {
                public Object run() {
                    try {
                        if (loader != null) {
                            return loader.getResources(name);
                        } else {
                            return ClassLoader.getSystemResources(name);
                        }
                    } catch(IOException e) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                "Exception while trying to find configuration file "
                                + name + ":" + e.getMessage());
                        }
                        return null;
                    } catch(NoSuchMethodError e) {
                        // we must be running on a 1.1 JVM which doesn't support
                        // ClassLoader.getSystemResources; just return null in
                        // this case.
                        return null;
                    }
                }
            };
        Object result = AccessController.doPrivileged(action);
        return (Enumeration) result;
    }


    private static Properties getProperties(final URL url) {
        PrivilegedAction action = 
            new PrivilegedAction() {
                public Object run() {
                    try {
                        InputStream stream = url.openStream();
                        if (stream != null) {
                            Properties props = new Properties();
                            props.load(stream);
                            stream.close();
                            return props;
                        }
                    } catch(IOException e) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic("Unable to read URL " + url);
                        }
                    }

                    return null;
                }
            };
        return (Properties) AccessController.doPrivileged(action);
    }


    private static final Properties getConfigurationFile(
            ClassLoader classLoader, String fileName) {

        Properties props = null;
        double priority = 0.0;
        URL propsUrl = null;
        try {
            Enumeration urls = getResources(classLoader, fileName);

            if (urls == null) {
                return null;
            }
            
            while (urls.hasMoreElements()) {
                URL url = (URL) urls.nextElement();
                
                Properties newProps = getProperties(url);
                if (newProps != null) {
                    if (props == null) {
                        propsUrl = url; 
                        props = newProps;
                        String priorityStr = props.getProperty(PRIORITY_KEY);
                        priority = 0.0;
                        if (priorityStr != null) {
                            priority = Double.parseDouble(priorityStr);
                        }

                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                "[LOOKUP] Properties file found at '" + url + "'"
                                + " with priority " + priority); 
                        }
                    } else {
                        String newPriorityStr = newProps.getProperty(PRIORITY_KEY);
                        double newPriority = 0.0;
                        if (newPriorityStr != null) {
                            newPriority = Double.parseDouble(newPriorityStr);
                        }

                        if (newPriority > priority) {
                            if (isDiagnosticsEnabled()) {
                                logDiagnostic(
                                    "[LOOKUP] Properties file at '" + url + "'"
                                    + " with priority " + newPriority 
                                    + " overrides file at '" + propsUrl + "'"
                                    + " with priority " + priority);
                            }

                            propsUrl = url; 
                            props = newProps;
                            priority = newPriority;
                        } else {
                            if (isDiagnosticsEnabled()) {
                                logDiagnostic(
                                    "[LOOKUP] Properties file at '" + url + "'"
                                    + " with priority " + newPriority 
                                    + " does not override file at '" + propsUrl + "'"
                                    + " with priority " + priority);
                            }
                        }
                    }

                }
            }
        } catch (SecurityException e) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("SecurityException thrown while trying to find/read config files.");
            }
        }

        if (isDiagnosticsEnabled()) {
            if (props == null) {
                logDiagnostic(
                    "[LOOKUP] No properties file of name '" + fileName
                    + "' found.");
            } else {
                logDiagnostic(
                    "[LOOKUP] Properties file of name '" + fileName
                    + "' found at '" + propsUrl + '"');
            }
        }

        return props;
    }


    private static String getSystemProperty(final String key, final String def)
    throws SecurityException {
        return (String) AccessController.doPrivileged(
                new PrivilegedAction() {
                    public Object run() {
                        return System.getProperty(key, def);
                    }
                });
    }


    private static void initDiagnostics() {
        String dest;
        try {
            dest = getSystemProperty(DIAGNOSTICS_DEST_PROPERTY, null);
            if (dest == null) {
                return;
            }
        } catch(SecurityException ex) {
            // We must be running in some very secure environment.
            // We just have to assume output is not wanted..
            return;
        }

        if (dest.equals("STDOUT")) {
            diagnosticsStream = System.out;
        } else if (dest.equals("STDERR")) {
            diagnosticsStream = System.err;
        } else {
            try {
                // open the file in append mode
                FileOutputStream fos = new FileOutputStream(dest, true);
                diagnosticsStream = new PrintStream(fos);
            } catch(IOException ex) {
                // We should report this to the user - but how?
                return;
            }
        }

        // In order to avoid confusion where multiple instances of JCL are
        // being used via different classloaders within the same app, we
        // ensure each logged message has a prefix of form
        // [LogFactory from classloader OID]
        //
        // Note that this prefix should be kept consistent with that 
        // in LogFactoryImpl. However here we don't need to output info
        // about the actual *instance* of LogFactory, as all methods that
        // output diagnostics from this class are static.
        String classLoaderName;
        try {
            ClassLoader classLoader = thisClassLoader;
            if (thisClassLoader == null) {
                classLoaderName = "BOOTLOADER";
            } else {
                classLoaderName = objectId(classLoader);
            }
        } catch(SecurityException e) {
            classLoaderName = "UNKNOWN";
        }
        diagnosticPrefix = "[LogFactory from " + classLoaderName + "] ";
    }


    protected static boolean isDiagnosticsEnabled() {
        return diagnosticsStream != null;
    }


    private static final void logDiagnostic(String msg) {
        if (diagnosticsStream != null) {
            diagnosticsStream.print(diagnosticPrefix);
            diagnosticsStream.println(msg);
            diagnosticsStream.flush();
        }
    }


    protected static final void logRawDiagnostic(String msg) {
        if (diagnosticsStream != null) {
            diagnosticsStream.println(msg);
            diagnosticsStream.flush();
        }
    }


    private static void logClassLoaderEnvironment(Class clazz) {
        if (!isDiagnosticsEnabled()) {
            return;
        }
        
        try {
            // Deliberately use System.getProperty here instead of getSystemProperty; if
            // the overall security policy for the calling application forbids access to
            // these variables then we do not want to output them to the diagnostic stream. 
            logDiagnostic("[ENV] Extension directories (java.ext.dir): " + System.getProperty("java.ext.dir"));
            logDiagnostic("[ENV] Application classpath (java.class.path): " + System.getProperty("java.class.path"));
        } catch(SecurityException ex) {
            logDiagnostic("[ENV] Security setting prevent interrogation of system classpaths.");
        }
        
        String className = clazz.getName();
        ClassLoader classLoader;
        
        try {
            classLoader = getClassLoader(clazz);
        } catch(SecurityException ex) {
            // not much useful diagnostics we can print here!
            logDiagnostic(
                "[ENV] Security forbids determining the classloader for " + className);
            return;
        }

        logDiagnostic(
            "[ENV] Class " + className + " was loaded via classloader "
            + objectId(classLoader));
        logHierarchy("[ENV] Ancestry of classloader which loaded " + className + " is ", classLoader);
    }


    private static void logHierarchy(String prefix, ClassLoader classLoader) {
        if (!isDiagnosticsEnabled()) {
            return;
        }
        ClassLoader systemClassLoader;
        if (classLoader != null) {
            final String classLoaderString = classLoader.toString();
            logDiagnostic(prefix + objectId(classLoader) + " == '" + classLoaderString + "'");
        }
        
        try {
            systemClassLoader = ClassLoader.getSystemClassLoader();
        } catch(SecurityException ex) {
            logDiagnostic(
                    prefix + "Security forbids determining the system classloader.");
            return;
        }        
        if (classLoader != null) {
            StringBuffer buf = new StringBuffer(prefix + "ClassLoader tree:");
            for(;;) {
                buf.append(objectId(classLoader));
                if (classLoader == systemClassLoader) {
                    buf.append(" (SYSTEM) ");
                }

                try {
                    classLoader = classLoader.getParent();
                } catch(SecurityException ex) {
                    buf.append(" --> SECRET");
                    break;
                }

                buf.append(" --> ");
                if (classLoader == null) {
                    buf.append("BOOT");
                    break;
                }
            }
            logDiagnostic(buf.toString());
        }
    }


    public static String objectId(Object o) {
        if (o == null) {
            return "null";
        } else {
            return o.getClass().getName() + "@" + System.identityHashCode(o);
        }
    }

    // ----------------------------------------------------------------------
    // Static initialiser block to perform initialisation at class load time.
    //
    // We can't do this in the class constructor, as there are many 
    // static methods on this class that can be called before any
    // LogFactory instances are created, and they depend upon this
    // stuff having been set up.
    //
    // Note that this block must come after any variable declarations used
    // by any methods called from this block, as we want any static initialiser
    // associated with the variable to run first. If static initialisers for
    // variables run after this code, then (a) their value might be needed
    // by methods called from here, and (b) they might *override* any value
    // computed here!
    //
    // So the wisest thing to do is just to place this code at the very end
    // of the class file.
    // ----------------------------------------------------------------------

    static {
        // note: it's safe to call methods before initDiagnostics (though
        // diagnostic output gets discarded).
        thisClassLoader = getClassLoader(LogFactory.class);
        initDiagnostics();
        logClassLoaderEnvironment(LogFactory.class);
        factories = createFactoryStore();
        if (isDiagnosticsEnabled()) {
            logDiagnostic("BOOTSTRAP COMPLETED");
        }
    }
}
