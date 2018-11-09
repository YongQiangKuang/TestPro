package com.kyq.test.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Description:
 * Copyright: © 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2017-11-03 15:04
 */
public class DateTest {
    public static int i = 1;
//    static {
//        System.out.println(i);
//    }
    public static void main(String args[]){
//        System.out.println(parseDate("2017-08-09","yyyy-MM-dd"));
//        System.out.println(parseDate("2017-8-9","yyyy-MM-dd"));
//        System.out.println(DateTest.class.getName());
//        timeZoneChange();

    }
    public static void timeZoneChange(){
        //PDT时间
        String str = "2018-04-25 09:28:09";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date temp = format.parse(str);
            System.out.println(format.format(temp));
            System.out.println(temp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static Date parseDate(String strDate, String datePattern) {
        Date retDate = null;
        if (strDate != null) {
            if (strDate.contains("T")) {
                strDate = strDate.replace("T", " ");
            }
            if (strDate.length() <= 10) {
                strDate = strDate + " 00:00:00";
            }
            SimpleDateFormat sf = new SimpleDateFormat(datePattern);
            try {
                retDate = sf.parse(strDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retDate;
    }
}
