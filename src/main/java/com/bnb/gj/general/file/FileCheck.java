package com.bnb.gj.general.file;

import java.io.File;
import java.util.regex.Matcher;

public class FileCheck {

	public static void main(String[] args) {
		System.out.println("File.separatorChar >> "+File.separatorChar);
		var s = "/config/template/emails";
		s = s.replaceAll("/", Matcher.quoteReplacement(File.separator));
		System.out.println("s >> "+s);

	}

}
