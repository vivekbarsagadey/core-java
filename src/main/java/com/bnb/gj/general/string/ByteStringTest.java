package com.bnb.gj.general.string;

import java.util.regex.Pattern;

public class ByteStringTest {

	public static void main(String[] args) {
			new ByteStringTest().process(new StringProcesser());
	}
	
	private void process(StringProcesser processer) {
		
		String data = "|w:font:32| this is name 1 data $name\r\n" + 
				"|w:font:20| this is name 2 data $name\r\n" + 
				"|w:font:40| this is name 3 data $name";
		data = processer.buildFont(data);
		
		System.out.println("data >>> "+data);
		
	}

}

class StringProcesser{
	
	public String buildFont(String str) {
		return str.replaceAll(Pattern.quote("|w:font:32|"), "123");
	}
	
	
}
