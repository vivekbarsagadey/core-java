package com.bnb.gj.general.string;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class StringTest {

	public static void main(String[] args) {
		System.out.println(DateUtils.asLocalDate(new Date()));

		BigDecimal amtAfterTax = new BigDecimal(0);

		amtAfterTax.add(new BigDecimal(20));

		System.out.println(amtAfterTax);

		Locale list[] = SimpleDateFormat.getAvailableLocales();
		Set set = new TreeSet();
		for (int i = 0; i < list.length; i++) {
			//System.out.println(">>>>>>>>>>>>>>>");
			//System.out.println(list[i].getDisplayScript());
			//System.out.println("--------------------");
			for(var l : list[i].getISOLanguages()) {
				//System.out.println(l);
			}
			
			//System.out.println(list[i].getISOLanguages());
		}
		
		
		System.out.println(System.getProperty("user.language"));
		System.out.println(System.getProperty("user.country"));
		
		
		String test = "my test";
		System.out.println(test);
		StringTest tt = new StringTest();
		tt.changeString(test);
		System.out.println(test);
		
		
		
		
		AtomicReference<BigDecimal> autoRef=new AtomicReference<>(BigDecimal.ONE);	
		
		System.out.println("Old value >>>> " + autoRef.get());
		tt.changeBig(autoRef);
		System.out.println("New value >>>>> " +autoRef.get());
		System.out.println(">>>"+tt.getPasword());
	}
	
	
	private String getPasword() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().substring(0, 8);
		
	}
	
	private void changeString(String data) {
		data = "new test";
		
	}
	
	private void changeBig(AtomicReference<BigDecimal> val) {
		val.set(val.get().add(new BigDecimal(30)));
		
	}
	
	
	
	
}
