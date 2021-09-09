package com.nagarro.redisspringdemo;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AuEncrypter {

	private static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5PADDING";
	private static final String AES_ENCRYPTION_ALOGRITHM = "AES";
	private static final String ENC_KEY = "APuZKpRBPv8aEenc";

	/**
	 * Method for Encrypt Plain String Data
	 * 
	 * @param plainText
	 * @param key
	 * @return encryptedText
	 */
	public static String encrypt(String mobile) {
		String encryptedText = "";
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
			byte[] key = ENC_KEY.getBytes(StandardCharsets.UTF_8);
			SecretKeySpec secretKey = new SecretKeySpec(key, AES_ENCRYPTION_ALOGRITHM);
			IvParameterSpec ivparameterspec = new IvParameterSpec(key);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);
			byte[] cipherText = cipher.doFinal(mobile.getBytes());
			Base64.Encoder encoder = Base64.getEncoder();
			encryptedText = encoder.encodeToString(cipherText);

		} catch (Exception E) {
			System.err.println("Encrypt Exception : " + E.getMessage());
		}
		return encryptedText;
	}
	
	public static void main(String args[]) {
		System.out.println(encrypt("9582843303"));
	}
}
