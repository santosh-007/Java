package com.java;
import java.net.URLDecoder;

import psms.Constants;
import psms.Resource;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;

import psms.auth.User;
import psms.utils.PsmsLogger;
/**
*
* @author Santosh Anand
* Contains methods that are used for AES encryption and decryption
* Encryption Algorithm : AES
* Mode : CBC
* Key Size in Bits : 128,192,256
* IV (initialization vector) : block@valuefirst
* Encryption Key : block@valuefirst,block@valuefirst12345678,block@valuefirst123456valuefirst
* online https://www.devglan.com/online-tools/aes-encryption-decryption
*/
public class AESEncryptionStrategy implements EncryptionStrategy{

	    Logger logger =  PsmsLogger.getServiceLogger();
	    Logger errorLogger =  PsmsLogger.getErrorLogger();
	   //Length of secret key should be 16 for 128 bits key size
		private static final String AES_ENC_key_128 = "block@valuefirst";
		
		//Length of secret key should be 24 for 192 bits key size
		private static final String AES_ENC_key_192 = "block@valuefirst12345678";

		//Length of secret key should be 32 for 256 bits key size
		//private static final String AES_ENC_key_256 = "block@valuefirst123456valuefirst";
		 
		private static String key="";
		 
		private static final String initVector = "block@valuefirst";
		
		/*
	    	 * CR Point:---
	    	  PROCESS_ENCRYPTION=1  then  client will send all data 
	    	  (username, password, to, from, text, email id and email text.) in encrypted format 
	          <USER USERNAME="demo" PASSWORD="demo" PROCESS_ENCRYPTION = "1" />
	    */
	    	    
	
	   public  String getKey(int keySize){
	    	if(keySize==128){
				key=AES_ENC_key_128;
			}else if(keySize==192){
				key=AES_ENC_key_192;
			}else if(keySize==256){
				//key=AES_ENC_key_256;
				key=Resource.getProperty("AES_ENC_key_256").trim();
			}
	    	return key;
	    }
	   
	 public String encryptData(String plaintext,int keySize) {
		 try {
	            key = getKey(keySize);
	            if(!key.isEmpty()){
	    		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	    		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

	    		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	    		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

	    		byte[] encrypted = cipher.doFinal(plaintext.getBytes());
	    		return DatatypeConverter.printBase64Binary(encrypted);
	            }
	    	} catch (Exception ex) {
	    		errorLogger.error("Exception in AESEncryptionStrategy.encryptData() : "+ex.toString());
	    		ex.printStackTrace();
	    	}
			return plaintext;
	 }
	 
	 /* Called to decrypt data. If key is blank, it does not encrypt data.
	     * key is blank when pass different value i.e. not 128,192,256 in keySize parameter
	     */ 
	    public String decryptData(String encrypted,int keySize,String parameter,User userObj) {
	    	byte[] original = null;
	    	try {
	    		key = getKey(keySize);
	    		if(userObj != null && (Constants.ENABLE_DEBUG || userObj.getEnableDebug() == 1)){
	    		 logger.info("AES encrypted input ["+parameter+"]:"+encrypted);
	    		}
	    		//%3D
	    		if(!encrypted.contains("+")){
	    		 encrypted=URLDecoder.decode(encrypted, "UTF-8");
	    		// logger.info("AES encrypted after URLDecoder [text]:"+encrypted+" [keySize]: "+keySize+" [parameter]: "+parameter);
	    		}
	    		if(!key.isEmpty()){
	    		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	    		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

	    		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	    		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	    		 original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));
	    		//return new String(original);
	    		}
	    	} catch (Exception ex) {
	    		errorLogger.error("Exception in AESEncryptionStrategy.decryptData() : "+ex.toString()+" for parameter:"+parameter);
	    		//ex.printStackTrace();
	    	}
	    	//return encrypted;
	    	return new String(original);
	    }
	    
	    /**
	     * Method to decrypt given encrypted data using provided key.
	     */
	    public  String decrypt(String encrypted,String key) {
	    	try {
	    		//logger.info("AES encrypted input [text]:"+encrypted);
	    		
	    		if(!key.isEmpty()){
	    		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	    		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

	    		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	    		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	    		byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));
	    		//byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
	    		return new String(original);
	    		}
	    	} catch (Exception ex) {
	    		errorLogger.error("Exception in AESEncryption.decrypt() : "+ex.toString());
	    		ex.printStackTrace();
	    	}
	    	return encrypted;
	    }

}
