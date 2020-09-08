package com.bnb.gj.general.spring;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.springframework.util.ResourceUtils;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

public class GTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static String getTocken() throws Exception {
		File file = ResourceUtils.getFile("classpath:application_default_credentials.json");
		FileInputStream serviceAccount = new FileInputStream(file);
		GoogleCredential googleCred = GoogleCredential.fromStream(serviceAccount);
		GoogleCredential scoped = googleCred.createScoped(Arrays.asList(
				"https://www.googleapis.com/auth/firebase.database", "https://www.googleapis.com/auth/userinfo.email"));
		scoped.refreshToken();
		String token = scoped.getAccessToken();
		
		return token;
	}

}
