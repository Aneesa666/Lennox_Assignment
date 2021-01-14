package com.lennox.automation.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static String convertStringToDate(String value) {
		Date myDate = new Date(value);
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy", Locale.US);
		return formatter.format(myDate);
	}
}