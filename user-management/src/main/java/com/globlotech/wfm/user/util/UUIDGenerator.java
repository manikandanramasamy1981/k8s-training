package com.globlotech.wfm.user.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UUIDGenerator {
	
	public static String getUUID() throws NoSuchAlgorithmException ,
	UnsupportedEncodingException{
		UUID uuid = UUID.randomUUID();
		String stringUuid = uuid.toString();
		return stringUuid;
		
	}
	
	public String byteArrayToString(byte[] byteArray) {
		StringBuffer hexStringBuffer = new StringBuffer();
	    for (int i = 0; i < byteArray.length; i++) {
	        hexStringBuffer.append(byteToHex(byteArray[i]));
	    }
	    return hexStringBuffer.toString();
	}
	
	
	public String encodeHexString(byte[] byteArray) {
	    StringBuffer hexStringBuffer = new StringBuffer();
	    for (int i = 0; i < byteArray.length; i++) {
	        hexStringBuffer.append(byteToHex(byteArray[i]));
	    }
	    return hexStringBuffer.toString();
	}
	
	public String byteToHex(byte num) {
	    char[] hexDigits = new char[2];
	    hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
	    hexDigits[1] = Character.forDigit((num & 0xF), 16);
	    return new String(hexDigits);
	}
	
	public static void main(String args[]) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		UUIDGenerator uuidgenerator = new UUIDGenerator();
		System.out.println("UUID+++++"+uuidgenerator.getUUID());
		System.out.println("UUID default+++++"+UUID.randomUUID());
		System.out.println("UUID+++++"+UUIDGenerator.getUUID());
		
	}

}
