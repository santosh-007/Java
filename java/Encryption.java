package com.java;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;


public class Encryption{

 public static String KEY_STRING = "santosh";
	
    public static void main(String[] args) throws Exception {
      Encryption enc = new Encryption();
      // String clean = args[0];
      String clean = "EeugtwwZP6Y=";
       //String  encrypted="mxVT/tJmteQfVN+/LN6yjRX1nZ53C0d/SJqu5VF0suHiaA58A8L21szi6RqrCTSlBsgMdncENNJBcLXqAValqw==";
       String encrypted = enc.EncryptText(clean);
      // String encrypted = "yub/XAvsC1JFeCpYwLtCC1YuwKiz8PPia4mdTCaLAhcp1A5LMIU+OFiWqKcZMXY24kg2wgegXvqP6M7juS2w/rFCGkEKLvPDBjzW8LEEebpTh0ftvrOYbR2N/rwDvrwxYHJW+Iwsw/cXGIwBJ6BWkVexYJP/5W/4mQudMenbeopgrq1HOyWusdWZ/hXmrMFUK2bb0n40f0mPGHSCq9C+m9jVn/RuNmyeRC7CG1HAL2ylUW3hB1lMzWXS8QoCm8Nu90x5Se+9QHGw1HHXy2AN1XCKJ7DDj21ZgaQh59nWodFaYVwqC4FwC4Lic+0Eja";
//       String encrypted = "f4040c35a699c3f61cc500b045815037d97b048be8cea16582d4156e9d71b8a0";   
       System.out.println("text encrypt:::::"+encrypted);
          byte[] encryptedBytes = enc.decoder(encrypted);
          String decrypted = enc.DecryptText(encryptedBytes);
          System.out.println("text decrypt:::::"+decrypted);
    	//System.out.println(EncryptText("tulsi123"));
    	//System.out.println("fgdhgd"+decrypt("tn-verisure"));
    	//System.out.println(decrypt("je+v/uqoV6BrMeZnFafQtJRWvi0Pm715RgFiaUMZyy8="));

    }

    public String encoder(byte[] inputBytes) throws UnsupportedEncodingException {

        // Convert the string to UTF8 bytes for md5 input
      //  byte[] inputBytes = param.getBytes("UTF8");

        return Base64.getEncoder().encodeToString(inputBytes);
      }

      public static byte[] decoder(String param) throws IOException {

        byte[] dd = Base64.getDecoder().decode(param);
        //byte[] decoded = decoder.decodeBuffer(param);
        return dd;
      }
      
      
      public String decrypt(String encrypted){
    	 
    	String decrypted=null;
		try {
			byte[] encryptedBytes = decoder(encrypted);
			  decrypted = DecryptText(encryptedBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          return decrypted;
      }
      
    /**
     *   
     * @param plainText
     * @return
     * @throws Exception using AES SHA-256
     */
    public String EncryptText(String plainText) throws Exception {
        byte[] clean = plainText.getBytes();
        //System.out.println("Inside encryption plain text :::::"+plainText);

        // Generating IV.
        int ivSize = 16;
        byte[] iv = new byte[ivSize];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        // Hashing key.
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(KEY_STRING.getBytes("UTF-8"));
        byte[] keyBytes = new byte[16];
        System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        // Encrypt.
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(clean);

        // Combine IV and encrypted part.
        byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
        System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);

        
        //System.out.println("Inside encryption text encrypt:::::"+encoder(encryptedIVAndText));
       // String encryptedValue = (new BASE64Encoder()).encode(encVal).replaceAll("[\"|\\|\n\r\t\b']", "");

        return encoder(encryptedIVAndText).replaceAll("[\"|\\|\n\r\t\b']", "");
    }

    public String DecryptText(byte[] encryptedIvTextBytes) throws Exception {
    	int ivSize = 16;
        int keySize = 16;
        // Extract IV.
        byte[] iv = new byte[ivSize];
        System.arraycopy(encryptedIvTextBytes, 0, iv, 0, iv.length);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        // Extract encrypted part.
        int encryptedSize = encryptedIvTextBytes.length - ivSize;
        byte[] encryptedBytes = new byte[encryptedSize];
        System.arraycopy(encryptedIvTextBytes, ivSize, encryptedBytes, 0, encryptedSize);

        // Hash key.
        byte[] keyBytes = new byte[keySize];
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(KEY_STRING.getBytes());
        System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        // Decrypt.
        Cipher cipherDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

        return new String(decrypted);
}
}