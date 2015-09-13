package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public class TimeUtil {

	public static int compareToCurrent(String time) {
		Date sysDate=new Date();  
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			Date timeDate = df.parse(time);
			return sysDate.compareTo(timeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		}
		
	}
}
