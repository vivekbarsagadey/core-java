package com.bnb.gj.general.license;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class ScratchSpace {

	public static void main(String[] args) {
		 String userName = "Max Headroom";
	        String productKey = "ABCD";
	        String versionNumber = "4";
	        
	        LocalDate today = LocalDate.now();
	        String pattern = "MM-dd-yyyy";
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	        
	        today.plusYears(1);
	        
	        String date = today.getMonthValue() +"-"+ today.getDayOfMonth() + "-" + today.getYear();
	        System.out.println("date" + date);

	        final String licenseKey = createLicenseKey(userName, productKey, versionNumber , date);
	        System.out.println("licenseKey = " + licenseKey);

	}

	
	public static String createLicenseKey(String userName, String productKey, String versionNumber, String date) {
        final String s = userName + "|" + productKey + "|" + versionNumber + "|" +date ;
        System.out.println(s);
        final HashFunction hashFunction = Hashing.sha1();
        final HashCode hashCode = hashFunction.hashString(s, Charset.defaultCharset());
        final String upper = hashCode.toString().toUpperCase();
        return group(upper);
    }

    private static String group(String s) {
        String result = "";
        for (int i=0; i < s.length(); i++) {
            if (i%6==0 && i > 0) {
                result += '-';
            }
            result += s.charAt(i);
        }
        return result;
    }
}
