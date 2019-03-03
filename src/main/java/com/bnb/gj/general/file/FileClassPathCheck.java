package com.bnb.gj.general.file;

import java.net.URI;
import java.net.URISyntaxException;

public class FileClassPathCheck {

	public static void main(String[] args) {
		try {
			System.out.println(new FileClassPathCheck().path().getPath());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private URI path() throws URISyntaxException {
		return this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI();
	}
	
	/*
	 * private File createPropertiesFile(String relativeFilePath) throws
	 * URISyntaxException { return new File(new
	 * File(this.getClass().getProtectionDomain().getCodeSource().getLocation().
	 * toURI()), relativeFilePath); }
	 */

}
