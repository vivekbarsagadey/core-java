package com.bnb.gj.general.license;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class ScratchSpace {
	
	final static public DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
	final static public DateTimeFormatter DATE_STD_FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	
	public static String getDateStringFromDate(Date date , DateTimeFormatter dateTimeFormatter) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime().format(dateTimeFormatter);

	}


	public static void main(String[] args) {
		String userName = "cc71b269-6e14-4f62-9323-160ce7f4dace";
		String productKey = "wiki";
		String versionNumber = "1.2";

		LocalDate today = LocalDate.now();
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		today = today.plusDays(20);

		String date = today.getMonthValue() + "-" + today.getDayOfMonth() + "-" + today.getYear();
		System.out.println("date" + date);
		
		var datestr = getDateStringFromDate(new Date(), DATE_STD_FORMATTER);
		System.out.println("datestr"+datestr);
		
		//date = "11-04-2019";

		final String licenseKey = createLicenseKey(userName, productKey, versionNumber, date);
		System.out.println("licenseKey = " + licenseKey);

	}

	public static String createLicenseKey(String userName, String productKey, String versionNumber, String date) {
		final String s = userName + "|" + productKey + "|" + versionNumber + "|" + date;
		System.out.println(s);
		final HashFunction hashFunction = Hashing.sha1();
		final HashCode hashCode = hashFunction.hashString(s, Charset.defaultCharset());
		final String upper = hashCode.toString().toUpperCase();
		return group(upper);
	}

	private static String group(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (i % 6 == 0 && i > 0) {
				result += '-';
			}
			result += s.charAt(i);
		}
		return result;
	}
}
