package com.bnb.gj.general.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest {
	
	public static void main(String[] args) {
		
		BigDecimal value = new BigDecimal(33.99);
		System.out.println(value.negate());
		
		BigDecimal scaled = value.setScale(0, RoundingMode.CEILING);
		var roundOff = scaled.subtract(value);
		
		//roundOff.round(new MathContext(2, RoundingMode.CEILING));
		
		System.out.println(value + " -> " + roundOff.floatValue());
		
	}

}
