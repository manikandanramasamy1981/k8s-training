package com.globlotech.wfm.user.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {
	
	public static final String DATE_FORMAT_1 = "dd-MM-yyyy";
	
	public static final String DATE_FORMAT_2 = "dd-MMM-yyyy HH:mm:ss";
	
	
	public static String convertDateToString(Date date) {
		
		 // Converts the string
        // format to date object
        DateFormat df = new SimpleDateFormat();
  
        // Get the date using calendar object
        Date today = Calendar.getInstance().getTime();
  
        // Convert the date into a
        // string using format() method
        String dateToString = df.format(today);
  
        // Return the result
        return (dateToString);	
        
	}
	
	// To get dd/MM/yyyy  - pass 1
	// To get dd-MMM-YYYY HH:mm:ss   - pass 2
	
	public static Date convertStringToDate(String strDate , int format) {
		
		SimpleDateFormat formatter1=new SimpleDateFormat(DATE_FORMAT_1);
		SimpleDateFormat formatter2=new SimpleDateFormat(DATE_FORMAT_2);
		
		 Date date = null;

		 try {
			
			if(format==1) {
				date = formatter1.parse(strDate);	
			}else if (format==2) {
				date = formatter2.parse(strDate);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return date;
	}
	
	public static Timestamp getCurrentTimeStamp() {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		return timeStamp;
	}
	
	public static String getCurrentDate(int format) {
		Date date = Calendar.getInstance().getTime();
		String strDate = null;
		if(format ==1) {
			DateFormat dateFormat1 = new SimpleDateFormat(DATE_FORMAT_1);  
		    strDate = dateFormat1.format(date);  	
		} else if (format ==2) {
			DateFormat dateFormat2 = new SimpleDateFormat(DATE_FORMAT_2);  
		    strDate = dateFormat2.format(date);  	
		}
        return strDate;	
	}
}
