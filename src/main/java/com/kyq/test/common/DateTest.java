package com.kyq.test.common;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public static void main(String args[]){
//        System.out.println(parseDate("2017-08-09","yyyy-MM-dd"));
//        System.out.println(parseDate("2017-8-9","yyyy-MM-dd"));
        String str = "2017-08-09T00";
        System.out.println(str.substring(0,10));


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
