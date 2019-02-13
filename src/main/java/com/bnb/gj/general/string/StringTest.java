package com.bnb.gj.general.string;

import java.math.BigDecimal;
import java.util.Date;

public class StringTest {

	public static void main(String[] args) {
		System.out.println(DateUtils.asLocalDate(new Date()));
		
		
		BigDecimal amtAfterTax = new BigDecimal(0);
		
		amtAfterTax.add(new BigDecimal(20));
		
		System.out.println(amtAfterTax);
		
		

	}

	
	
}
