package com.example.httpclientdemo.pojo;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @time Dec 29, 20154:59:56 PM
 *
 */
public class JavaScriptAESUtil {

    private static final String UTF_8_ENCODING = "utf-8";
    private static final String AES_ENCRYPT_KEY = "_JES_ENCRYPT_KEY";
    private static final String IV = "abcdef0123456789";
    
	/**
     * 生成密钥
     * 
     * @return
     */
    public static String generageKey() {
        String key = "";
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();
            key = Base64.encode(bytesKey);
            System.out.println("key : " + key);
        } catch (NoSuchAlgorithmException e) {
        	throw new RuntimeException(e);
        }
        return key;
    }
    
    
    public static String encrypt(String str) {
    	try {
			return encrypt(str, Base64.encode(AES_ENCRYPT_KEY.getBytes(UTF_8_ENCODING)));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
    }

    /**
     * 加密
     * @param str    待加密字符串
     * @param keyOfBase64    密钥
     * @return
     */
    public static String encrypt(String str, String keyOfBase64) {
        String returnStr = "";
        try {
            // key转换
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(keyOfBase64),"AES");
            // 加密
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // 用密匙初始化Cipher对象
            IvParameterSpec param = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec,param);
            byte[] result = cipher.doFinal(str.getBytes(UTF_8_ENCODING));
            returnStr = Base64.encode(result);
        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
        return returnStr;
    }

    
    public static String decrypt(String str) {
    	try {
			return decrypt(str,Base64.encode(AES_ENCRYPT_KEY.getBytes(UTF_8_ENCODING)));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
    }
    /**
     * 解密
     * @param str    待解密字符串
     * @param keyOfBase64    密钥
     * @return
     */
    public static String decrypt(String str, String keyOfBase64) {
        String returnStr = "";
        try {
            // key转换
        	SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(keyOfBase64),"AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // 用密匙初始化Cipher对象
            IvParameterSpec param = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,param);
            byte[] result = cipher.doFinal(Base64.decode(str));
//            System.out.println("decrypt : " + new String(result));
            returnStr = new String(result,UTF_8_ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnStr;
    }

    public static void main(String[] args) {
        String encrypt = encrypt("123");
        System.out.println(encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println(decrypt);
    }

}