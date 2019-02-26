package com.attra.utils;


import javax.crypto.Cipher;

import javax.crypto.KeyGenerator;

import javax.crypto.SecretKey;

import javax.xml.bind.DatatypeConverter;

import com.attra.driverscript.Driverscript;


public class AESEncryption extends Driverscript
{ 
    public static SecretKey getSecretEncryptionKey() throws Exception
    {

        KeyGenerator generator = KeyGenerator.getInstance("AES");

        generator.init(128); // The AES key size in number of bits

        SecretKey secKey = generator.generateKey();

        return secKey;

    }

     
    public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{

        // AES defaults to AES/ECB/PKCS5Padding in Java 7

        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);

        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());

        return byteCipherText;

    }

    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {

        // AES defaults to AES/ECB/PKCS5Padding in Java 7

        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.DECRYPT_MODE, secKey);

       byte[] bytePlainText = aesCipher.doFinal(byteCipherText);

        return new String(bytePlainText);

    }

    private static String  bytesToHex(byte[] hash) {

        return DatatypeConverter.printHexBinary(hash);

    }
    public static String passWord() throws Exception
    {
    	String pass="";
    	SecretKey secKey=AESEncryption.getSecretEncryptionKey();
		byte[] pwd = AESEncryption.encryptText(pass, secKey);
		String pwdE=AESEncryption.decryptText(pwd, secKey);
		return pwdE;
    }

}
