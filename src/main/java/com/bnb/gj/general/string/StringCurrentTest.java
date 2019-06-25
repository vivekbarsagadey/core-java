package com.bnb.gj.general.string;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class StringCurrentTest {

	public static void main(String[] args) {
		Currency currency = Currency.getInstance(Locale.getDefault());
		var dd = String.format("%s  %8.2f", currency.getSymbol() , BigDecimal.ZERO) ;

		System.out.println(dd);
	}
	
	
	
	

}
