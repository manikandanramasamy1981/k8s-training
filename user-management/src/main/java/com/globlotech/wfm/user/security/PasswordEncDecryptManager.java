package com.globlotech.wfm.user.security;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author Manikandan
 *
 */
@Component
public class PasswordEncDecryptManager {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordEncDecryptManager.class);

	private static Random rand = new Random((new Date()).getTime());

	/**
	 * @param str
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String encrypt(String str) {
		log.info("*************PasswordEncDecryptManager*****encrypt**********Entry****");
		@SuppressWarnings("restriction")
		BASE64Encoder encoder = new BASE64Encoder();
		byte[] salt = new byte[8];
		rand.nextBytes(salt);
		String encryptedPassword = encoder.encode(salt) + encoder.encode(str.getBytes()); 
		log.info("*************PasswordEncDecryptManager*****decrypt******"+encryptedPassword);
		log.info("*************PasswordEncDecryptManager*****decrypt*****Exit*");
		return encryptedPassword;
	}

	/**
	 * @param encstr
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String decrypt(String encstr) {
		log.info("*************PasswordEncDecryptManager*****encrypt**********Entry****");
		if (encstr.length() > 12) {
			String cipher = encstr.substring(12);
			String deCryptedString;
			@SuppressWarnings("restriction")
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				deCryptedString = new String(decoder.decodeBuffer(cipher));
				log.info("*************PasswordEncDecryptManager*****decrypt*****deCryptedString*"+deCryptedString);
				return deCryptedString;
			} catch (IOException e) {
				//  throw new InvalidImplementationException(
				//Fail
			}
		}
		log.info("*************PasswordEncDecryptManager*****encrypt***Exit****");
		return null;
	}
	
	public static void main(String args[]) {
		String str = "test";
		PasswordEncDecryptManager passwordEncDecryptManager = new PasswordEncDecryptManager();
		String encryptedString = passwordEncDecryptManager.encrypt(str);
		String decryptedString = passwordEncDecryptManager.decrypt(encryptedString);
		
		
	}
}
