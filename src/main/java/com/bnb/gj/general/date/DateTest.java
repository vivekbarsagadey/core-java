package com.bnb.gj.general.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		var currentDate = new Date();
		var nextDay =DateUtils.addDays(currentDate, 30);
		System.out.println("currentDate  >> "+ currentDate);
		System.out.println("nextDay >> "+ nextDay);
		
		System.out.println("getTotalNoOfDays >> "+ DateUtils.getTotalNoOfDays(nextDay, currentDate));
		
		LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		DateTest.show(localDate);

	}
	
	public static void show(LocalDate nDate) {
		
		System.out.println("Day of Week "+ DayOfWeek.from(nDate));
		System.out.println("Day of Week "+ DayOfWeek.from(nDate).getValue());
		System.out.println("Month of year "+ nDate.getMonth());
		System.out.println("Month of year "+ nDate.getMonthValue());
		System.out.println("Year "+ nDate.getYear());
		
	}

}
