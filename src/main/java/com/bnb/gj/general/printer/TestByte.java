package com.bnb.gj.general.printer;

public class TestByte {
	
	

	public static void main(String[] args) {
		final byte[] ChooseFontA = {27, 77, 0};
		System.out.println(new String(ChooseFontA).getBytes());
		
		
		var a = "[B@4517d9a3";
		System.out.println(new String(a).equalsIgnoreCase(new String(ChooseFontA)));

	}

}
