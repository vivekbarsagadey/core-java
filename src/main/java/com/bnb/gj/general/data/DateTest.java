package com.bnb.gj.general.data;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		var currentDate = new Date();
		var nextDay =DateUtils.addDays(currentDate, 30);
		System.out.println("currentDate  >> "+ currentDate);
		System.out.println("nextDay >> "+ nextDay);
		
		System.out.println("getTotalNoOfDays >> "+ DateUtils.getTotalNoOfDays(nextDay, currentDate));
		

	}

}
