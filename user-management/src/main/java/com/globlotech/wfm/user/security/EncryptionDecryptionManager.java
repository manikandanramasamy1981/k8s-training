package com.globlotech.wfm.user.security;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptionDecryptionManager {
	
	private static char[] password =  {'t','s','y'};
	
	private static String encrypt(String text) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray(password);
        String encryptedText = textEncryptor.encrypt(text);

        return encryptedText;
    }

    private static String decrypt(String text) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray(password);
        String decryptedText = textEncryptor.decrypt(text);

        return decryptedText;
    }
    
    public static void main(String a[]) {
    	
    	String plaintext = "test";
    	EncryptionDecryptionManager encryptionDecryptionManager = new EncryptionDecryptionManager();
    	String encrypted = encryptionDecryptionManager.encrypt(plaintext);
    	System.out.println("Encrypted ---"+encryptionDecryptionManager.encrypt(plaintext));
    	System.out.println("Decrypted ---"+encryptionDecryptionManager.decrypt(encrypted));
    }

}
