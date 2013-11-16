package com.beijing.fm1877.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilTools {
     public static String formatterNum(int time){
    	    	Date date=new Date(time);
    	    	DateFormat format=new SimpleDateFormat("mm:ss");
    	    	return format.format(date);
    	     }
     
}
