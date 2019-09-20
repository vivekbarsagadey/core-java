package com.bnb.gj.general.system;

import java.util.Optional;

public class JavaSystemTest {
	
	private static Double getDefaultValue(Double value) {
		return Optional.ofNullable(value).orElse(0.00) ;
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		
		System.out.println(getDefaultValue(null));

	}

}
