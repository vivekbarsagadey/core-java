package com.bnb.gj.general.data;

public enum Days {
	SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);

	private final int dayIndex;

	private Days(int dayIndex) {
		this.dayIndex = dayIndex;
	}

	public int getDayIndex() {
		return dayIndex;
	}
	
	public static String getName(int dayIndex) {
		for(Days d : Days.values()) {
			if(d.getDayIndex() == dayIndex) {
				return d.name();
			}
		}
		
		return "";
	}
	
	
}
