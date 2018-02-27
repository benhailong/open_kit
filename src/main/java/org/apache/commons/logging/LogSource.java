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


import java.lang.reflect.Constructor;
import java.util.Hashtable;

import org.apache.commons.logging.impl.NoOpLog;



public class LogSource {

    // ------------------------------------------------------- Class Attributes

    static protected Hashtable logs = new Hashtable();

    static protected boolean log4jIsAvailable = false;

    static protected boolean jdk14IsAvailable = false;

    static protected Constructor logImplctor = null;


    // ----------------------------------------------------- Class Initializers

    static {

        // Is Log4J Available?
        try {
            if (null != Class.forName("org.apache.log4j.Logger")) {
                log4jIsAvailable = true;
            } else {
                log4jIsAvailable = false;
            }
        } catch (Throwable t) {
            log4jIsAvailable = false;
        }

        // Is JDK 1.4 Logging Available?
        try {
            if ((null != Class.forName("java.util.logging.Logger")) &&
                (null != Class.forName("org.apache.commons.logging.impl.Jdk14Logger"))) {
                jdk14IsAvailable = true;
            } else {
                jdk14IsAvailable = false;
            }
        } catch (Throwable t) {
            jdk14IsAvailable = false;
        }

        // Set the default Log implementation
        String name = null;
        try {
            name = System.getProperty("org.apache.commons.logging.log");
            if (name == null) {
                name = System.getProperty("org.apache.commons.logging.Log");
            }
        } catch (Throwable t) {
        }
        if (name != null) {
            try {
                setLogImplementation(name);
            } catch (Throwable t) {
                try {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.NoOpLog");
                } catch (Throwable u) {
                    ;
                }
            }
        } else {
            try {
                if (log4jIsAvailable) {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.Log4JLogger");
                } else if (jdk14IsAvailable) {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.Jdk14Logger");
                } else {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.NoOpLog");
                }
            } catch (Throwable t) {
                try {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.NoOpLog");
                } catch (Throwable u) {
                    ;
                }
            }
        }

    }


    // ------------------------------------------------------------ Constructor


    private LogSource() {
    }


    // ---------------------------------------------------------- Class Methods


    static public void setLogImplementation(String classname) throws
            LinkageError, ExceptionInInitializerError,
            NoSuchMethodException, SecurityException,
            ClassNotFoundException {
        try {
            Class logclass = Class.forName(classname);
            Class[] argtypes = new Class[1];
            argtypes[0] = "".getClass();
            logImplctor = logclass.getConstructor(argtypes);
        } catch (Throwable t) {
            logImplctor = null;
        }
    }



    static public void setLogImplementation(Class logclass) throws
            LinkageError, ExceptionInInitializerError,
            NoSuchMethodException, SecurityException {
        Class[] argtypes = new Class[1];
        argtypes[0] = "".getClass();
        logImplctor = logclass.getConstructor(argtypes);
    }


    static public Log getInstance(String name) {
        Log log = (Log) (logs.get(name));
        if (null == log) {
            log = makeNewLogInstance(name);
            logs.put(name, log);
        }
        return log;
    }


    static public Log getInstance(Class clazz) {
        return getInstance(clazz.getName());
    }



    static public Log makeNewLogInstance(String name) {

        Log log = null;
        try {
            Object[] args = new Object[1];
            args[0] = name;
            log = (Log) (logImplctor.newInstance(args));
        } catch (Throwable t) {
            log = null;
        }
        if (null == log) {
            log = new NoOpLog(name);
        }
        return log;

    }



    static public String[] getLogNames() {
        return (String[]) (logs.keySet().toArray(new String[logs.size()]));
    }


}
