package com.bnb.gj.general.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
	final static public DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
	final static public DateTimeFormatter DATE_STD_FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	final static public DateTimeFormatter DATE_YYYY_MM_DD_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	
	public static Date addDays(String dateString,long days,DateTimeFormatter formatter) {
		if(formatter == null) {
			formatter = DATE_YYYY_MM_DD_FORMATTER;
		}
		return DateUtils.asDate(LocalDate.parse(dateString, DATE_YYYY_MM_DD_FORMATTER).plusDays(days));
	}
	
	public static long getTotalNoOfDays(Date fromDate, Date toDate) {
		return ChronoUnit.DAYS.between(asLocalDate(toDate), asLocalDate(fromDate));
	}
	
	public static Date addHouse(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return calendar.getTime();
	}
	public static Date addDays(Date date, int days) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, days);
	    return calendar.getTime();
	}

	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDateTime asLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	public static String asLocalDateTimeString(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime().format(FORMATTER);
	}

	public static String getDayFromDate(Date date) {
		return Days.getName(date.getDay());

	}
	
	public static String getDateStringFromDate(Date date , DateTimeFormatter dateTimeFormatter) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime().format(dateTimeFormatter);

	}
	
	public static Date getFistDateOfCurrentMonth() {
		 Calendar c = Calendar.getInstance();   
		    c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

}
