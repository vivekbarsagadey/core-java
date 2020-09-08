package com.bnb.gj.general.restclient;

import java.io.IOException;

public class RunTimeTest {

	public static void main(String[] args) {
		try {
			System.out.println(new RunTimeTest().execCmd("dir"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String execCmd(String cmd) throws Exception {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("cmd.exe "," gcloud "," auth ", " print-access-token ");
	    Process proc = processBuilder.start();
	    proc.waitFor();
	    java.io.InputStream is = proc.getInputStream();
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    String val = "";
	    if (s.hasNext()) {
	        val = s.next();
	    }
	    else {
	        val = "";
	    }
	    return val;
	}
	
	public String execCmdold(String cmd) throws Exception {
	    Process proc = Runtime.getRuntime().exec(cmd);
	    proc.waitFor();
	    java.io.InputStream is = proc.getInputStream();
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    String val = "";
	    if (s.hasNext()) {
	        val = s.next();
	    }
	    else {
	        val = "";
	    }
	    return val;
	}
	
	
}
