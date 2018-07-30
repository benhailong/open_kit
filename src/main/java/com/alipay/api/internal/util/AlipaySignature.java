/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.alipay.api.internal.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Cipher;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.codec.Base64;

public class AlipaySignature {

    private static final int MAX_ENCRYPT_BLOCK = 117;

    private static final int MAX_DECRYPT_BLOCK = 128;

    public static String getSignatureContent(RequestParametersHolder requestHolder) {
        return getSignContent(getSortedMap(requestHolder));
    }

    public static Map<String, String> getSortedMap(RequestParametersHolder requestHolder) {
        Map<String, String> sortedParams = new TreeMap<String, String>();
        AlipayHashMap appParams = requestHolder.getApplicationParams();
        if (appParams != null && appParams.size() > 0) {
            sortedParams.putAll(appParams);
        }
        AlipayHashMap protocalMustParams = requestHolder.getProtocalMustParams();
        if (protocalMustParams != null && protocalMustParams.size() > 0) {
            sortedParams.putAll(protocalMustParams);
        }
        AlipayHashMap protocalOptParams = requestHolder.getProtocalOptParams();
        if (protocalOptParams != null && protocalOptParams.size() > 0) {
            sortedParams.putAll(protocalOptParams);
        }

        return sortedParams;
    }


    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (StringUtils.areNotEmpty(key, value)) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }


    public static String rsaSign(String content, String privateKey, String charset,
                                 String signType) throws AlipayApiException {

        if (AlipayConstants.SIGN_TYPE_RSA.equals(signType)) {

            return rsaSign(content, privateKey, charset);
        } else if (AlipayConstants.SIGN_TYPE_RSA2.equals(signType)) {

            return rsa256Sign(content, privateKey, charset);
        } else {

            throw new AlipayApiException("Sign Type is Not Support : signType=" + signType);
        }

    }


    public static String rsa256Sign(String content, String privateKey,
                                    String charset) throws AlipayApiException {

        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(AlipayConstants.SIGN_TYPE_RSA,
                new ByteArrayInputStream(privateKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                .getInstance(AlipayConstants.SIGN_SHA256RSA_ALGORITHMS);

            signature.initSign(priKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();

            return new String(Base64.encodeBase64(signed));
        } catch (Exception e) {
            throw new AlipayApiException("RSAcontent = " + content + "; charset = " + charset, e);
        }

    }


    public static String rsaSign(String content, String privateKey,
                                 String charset) throws AlipayApiException {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(AlipayConstants.SIGN_TYPE_RSA,
                new ByteArrayInputStream(privateKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                .getInstance(AlipayConstants.SIGN_ALGORITHMS);

            signature.initSign(priKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();

            return new String(Base64.encodeBase64(signed));
        } catch (InvalidKeySpecException ie) {
            throw new AlipayApiException("RSA私钥格式不正确，请检查是否正确配置了PKCS8格式的私钥", ie);
        } catch (Exception e) {
            throw new AlipayApiException("RSAcontent = " + content + "; charset = " + charset, e);
        }
    }

    public static String rsaSign(Map<String, String> params, String privateKey,
                                 String charset) throws AlipayApiException {
        String signContent = getSignContent(params);

        return rsaSign(signContent, privateKey, charset);

    }

    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm,
                                                    InputStream ins) throws Exception {
        if (ins == null || StringUtils.isEmpty(algorithm)) {
            return null;
        }

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        byte[] encodedKey = StreamUtil.readText(ins).getBytes();

        encodedKey = Base64.decodeBase64(encodedKey);

        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    public static String getSignCheckContentV1(Map<String, String> params) {
        if (params == null) {
            return null;
        }

        params.remove("sign");
        params.remove("sign_type");

        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }

        return content.toString();
    }

    public static String getSignCheckContentV2(Map<String, String> params) {
        if (params == null) {
            return null;
        }

        params.remove("sign");

        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }

        return content.toString();
    }

    public static boolean rsaCheckV1(Map<String, String> params, String publicKey,
                                     String charset) throws AlipayApiException {
        String sign = params.get("sign");
        String content = getSignCheckContentV1(params);

        return rsaCheckContent(content, sign, publicKey, charset);
    }
    
    public static boolean rsaCheckV1(Map<String, String> params, String publicKey,
            String charset,String signType) throws AlipayApiException {
		String sign = params.get("sign");
		String content = getSignCheckContentV1(params);
		
		return rsaCheck(content, sign, publicKey, charset,signType);
    }

    public static boolean rsaCheckV2(Map<String, String> params, String publicKey,
                                     String charset) throws AlipayApiException {
        String sign = params.get("sign");
        String content = getSignCheckContentV2(params);

        return rsaCheckContent(content, sign, publicKey, charset);
    }
    
    public static boolean rsaCheckV2(Map<String, String> params, String publicKey,
            String charset,String signType) throws AlipayApiException {
		String sign = params.get("sign");
		String content = getSignCheckContentV2(params);
		
		return rsaCheck(content, sign, publicKey, charset,signType);
	}

    public static boolean rsaCheck(String content, String sign, String publicKey, String charset,
                                   String signType) throws AlipayApiException {

        if (AlipayConstants.SIGN_TYPE_RSA.equals(signType)) {

            return rsaCheckContent(content, sign, publicKey, charset);

        } else if (AlipayConstants.SIGN_TYPE_RSA2.equals(signType)) {

            return rsa256CheckContent(content, sign, publicKey, charset);

        } else {

            throw new AlipayApiException("Sign Type is Not Support : signType=" + signType);
        }

    }

    public static boolean rsa256CheckContent(String content, String sign, String publicKey,
                                             String charset) throws AlipayApiException {
        try {
            PublicKey pubKey = getPublicKeyFromX509("RSA",
                new ByteArrayInputStream(publicKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                .getInstance(AlipayConstants.SIGN_SHA256RSA_ALGORITHMS);

            signature.initVerify(pubKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
            throw new AlipayApiException(
                "RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, e);
        }
    }

    public static boolean rsaCheckContent(String content, String sign, String publicKey,
                                          String charset) throws AlipayApiException {
        try {
            PublicKey pubKey = getPublicKeyFromX509("RSA",
                new ByteArrayInputStream(publicKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                .getInstance(AlipayConstants.SIGN_ALGORITHMS);

            signature.initVerify(pubKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
            throw new AlipayApiException(
                "RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, e);
        }
    }

    public static PublicKey getPublicKeyFromX509(String algorithm,
                                                 InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        StringWriter writer = new StringWriter();
        StreamUtil.io(new InputStreamReader(ins), writer);

        byte[] encodedKey = writer.toString().getBytes();

        encodedKey = Base64.decodeBase64(encodedKey);

        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }


    public static String checkSignAndDecrypt(Map<String, String> params, String alipayPublicKey,
                                             String cusPrivateKey, boolean isCheckSign,
                                             boolean isDecrypt) throws AlipayApiException {
        String charset = params.get("charset");
        String bizContent = params.get("biz_content");
        if (isCheckSign) {
            if (!rsaCheckV2(params, alipayPublicKey, charset)) {
                throw new AlipayApiException("rsaCheck failure:rsaParams=" + params);
            }
        }

        if (isDecrypt) {
            return rsaDecrypt(bizContent, cusPrivateKey, charset);
        }

        return bizContent;
    }
    

    public static String checkSignAndDecrypt(Map<String, String> params, String alipayPublicKey,
                                             String cusPrivateKey, boolean isCheckSign,
                                             boolean isDecrypt, String signType) throws AlipayApiException {
        String charset = params.get("charset");
        String bizContent = params.get("biz_content");
        if (isCheckSign) {
            if (!rsaCheckV2(params, alipayPublicKey, charset,signType)) {
                throw new AlipayApiException("rsaCheck failure:rsaParams=" + params);
            }
        }

        if (isDecrypt) {
            return rsaDecrypt(bizContent, cusPrivateKey, charset);
        }

        return bizContent;
    }


    public static String encryptAndSign(String bizContent, String alipayPublicKey,
                                        String cusPrivateKey, String charset, boolean isEncrypt,
                                        boolean isSign) throws AlipayApiException {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(charset)) {
            charset = AlipayConstants.CHARSET_GBK;
        }
        sb.append("<?xml version=\"1.0\" encoding=\"" + charset + "\"?>");
        if (isEncrypt) {// 加密
            sb.append("<alipay>");
            String encrypted = rsaEncrypt(bizContent, alipayPublicKey, charset);
            sb.append("<response>" + encrypted + "</response>");
            sb.append("<encryption_type>RSA</encryption_type>");
            if (isSign) {
                String sign = rsaSign(encrypted, cusPrivateKey, charset);
                sb.append("<sign>" + sign + "</sign>");
                sb.append("<sign_type>RSA</sign_type>");
            }
            sb.append("</alipay>");
        } else if (isSign) {// 不加密，但需要签名
            sb.append("<alipay>");
            sb.append("<response>" + bizContent + "</response>");
            String sign = rsaSign(bizContent, cusPrivateKey, charset);
            sb.append("<sign>" + sign + "</sign>");
            sb.append("<sign_type>RSA</sign_type>");
            sb.append("</alipay>");
        } else {// 不加密，不加签
            sb.append(bizContent);
        }
        return sb.toString();
    }
    

    public static String encryptAndSign(String bizContent, String alipayPublicKey,
                                        String cusPrivateKey, String charset, boolean isEncrypt,
                                        boolean isSign,String signType) throws AlipayApiException {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(charset)) {
            charset = AlipayConstants.CHARSET_GBK;
        }
        sb.append("<?xml version=\"1.0\" encoding=\"" + charset + "\"?>");
        if (isEncrypt) {// 加密
            sb.append("<alipay>");
            String encrypted = rsaEncrypt(bizContent, alipayPublicKey, charset);
            sb.append("<response>" + encrypted + "</response>");
            sb.append("<encryption_type>RSA</encryption_type>");
            if (isSign) {
                String sign = rsaSign(encrypted, cusPrivateKey, charset, signType);
                sb.append("<sign>" + sign + "</sign>");
                sb.append("<sign_type>");
                sb.append(signType);
                sb.append("</sign_type>");
            }
            sb.append("</alipay>");
        } else if (isSign) {// 不加密，但需要签名
            sb.append("<alipay>");
            sb.append("<response>" + bizContent + "</response>");
            String sign = rsaSign(bizContent, cusPrivateKey, charset, signType);
            sb.append("<sign>" + sign + "</sign>");
            sb.append("<sign_type>");
            sb.append(signType);
            sb.append("</sign_type>");
            sb.append("</alipay>");
        } else {// 不加密，不加签
            sb.append(bizContent);
        }
        return sb.toString();
    }

    public static String rsaEncrypt(String content, String publicKey,
                                    String charset) throws AlipayApiException {
        try {
            PublicKey pubKey = getPublicKeyFromX509(AlipayConstants.SIGN_TYPE_RSA,
                new ByteArrayInputStream(publicKey.getBytes()));
            Cipher cipher = Cipher.getInstance(AlipayConstants.SIGN_TYPE_RSA);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] data = StringUtils.isEmpty(charset) ? content.getBytes()
                : content.getBytes(charset);
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密  
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = Base64.encodeBase64(out.toByteArray());
            out.close();

            return StringUtils.isEmpty(charset) ? new String(encryptedData)
                : new String(encryptedData, charset);
        } catch (Exception e) {
            throw new AlipayApiException("EncryptContent = " + content + ",charset = " + charset,
                e);
        }
    }

    public static String rsaDecrypt(String content, String privateKey,
                                    String charset) throws AlipayApiException {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(AlipayConstants.SIGN_TYPE_RSA,
                new ByteArrayInputStream(privateKey.getBytes()));
            Cipher cipher = Cipher.getInstance(AlipayConstants.SIGN_TYPE_RSA);
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            byte[] encryptedData = StringUtils.isEmpty(charset)
                ? Base64.decodeBase64(content.getBytes())
                : Base64.decodeBase64(content.getBytes(charset));
            int inputLen = encryptedData.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密  
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();

            return StringUtils.isEmpty(charset) ? new String(decryptedData)
                : new String(decryptedData, charset);
        } catch (Exception e) {
            throw new AlipayApiException("EncodeContent = " + content + ",charset = " + charset, e);
        }
    }

}
