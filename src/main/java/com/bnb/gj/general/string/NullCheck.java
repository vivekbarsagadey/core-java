package com.bnb.gj.general.string;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NullCheck {
	
	private String stringName = "old";
	
	public static void main(String[] args) {
		
		var  n = new NullCheck();
		n.test();
		
		
	}
	
	private void test() {
		try {
			stringName = test(null);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		System.out.println(stringName);
	}
	
	private String test(String name) throws Exception {
		Optional.ofNullable(name).orElseThrow(()-> new Exception("Email host is null"));
		
		return "new String";
	}

}
