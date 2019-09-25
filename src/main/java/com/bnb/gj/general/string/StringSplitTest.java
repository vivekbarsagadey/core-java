package com.bnb.gj.general.string;

public class StringSplitTest {
	
	private String data = "Item  Qty  Rate   Amount\r\n" + 
			"--------------------------------\r\n" + 
			"|w:line:just:50:Penne served in a Creamy Mushroom Sauce (Veg)||w:tab:horizontal|1  200|w:tab:horizontal|  222\r\n" + 
			"|w:line:just:50:Spaghetti Alio olio||w:tab:horizontal|4  400|w:tab:horizontal|  5552";

	public static void main(String[] args) {
		
		new StringSplitTest().init();
	}
	
	
	private void init() {
		
		int index = data.indexOf("|w:line:just:");
		int lastindex = data.indexOf("|",index+"|w:line:just:".length());
		System.out.println(index);
		System.out.println(lastindex);
		
		System.out.println(data.substring(index+"|w:line:just:".length(),lastindex));
		
		
		
	}

}
