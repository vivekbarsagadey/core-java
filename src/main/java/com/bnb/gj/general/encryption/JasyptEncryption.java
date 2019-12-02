package com.bnb.gj.general.encryption;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class JasyptEncryption {

	public static void main(String[] args) {
		String userPassword = "wiki$1.4$smartwiki&Masterkey";
		String inputPassword = "wiki$1.4$smartwiki&Masterkey";
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(userPassword);
		System.out.println(encryptedPassword);
		
		if (passwordEncryptor.checkPassword(inputPassword, encryptedPassword)) {
			System.out.println("Password matched");
		}else {
			System.out.println("Password Not matched");
		}

	}

}
