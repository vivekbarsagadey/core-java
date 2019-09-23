package com.bnb.gj.general.printer;

public class StringUtil {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}

	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}
	
	public static String padCentral(String s, int n) {
		var stringLen = s.length();
		var pendingLenth = n-stringLen;
		System.out.println(stringLen + " " + pendingLenth + " "+  pendingLenth/2);
		return padRight("", pendingLenth/2)+s;
	}
	
	public static void main(String[] args) {
		System.out.println(String.format(StringUtil.padRight("Veg Burgers-burgers",45)+"   "+StringUtil.padLeft("10",3)));
		System.out.println(String.format(StringUtil.padRight("Special Dal With Paratha-Full",45)+"   "+StringUtil.padLeft("3",3)));
		System.out.println(String.format(StringUtil.padRight("Veg Burgers",45)+"   "+StringUtil.padLeft("8",3)));
		System.out.println(ANSI_GREEN+String.format(StringUtil.padRight("Chef Special Cottage Cheese Mousse Curry-Full",45)+"   "+StringUtil.padLeft("6",3))+ANSI_RESET);
		
		var a="talli";
		var b= "Dhayari gaon";
		var c="Pune 411041";
		var d="Bill No : RN-TAL-000005";
		var e ="Date : 2019 09 04 19:52";
		
		System.out.println(padCentral(a, 100));
		System.out.println(padCentral(b, 100));
		System.out.println(padCentral(c, 100));
		System.out.println(padCentral(d, 100));
		System.out.println(padCentral(e, 100));
		System.out.println(String.format("%1$2s", "Hello"));
		
	}
	
	
	

}
