package com.kyq.test.common;

import java.util.Calendar;

/**
 * Description:
 * Copyright: © 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2017-12-05 11:06
 * -XX:+PrintGCDetails
 */
public class StringTest {
    public static void main(String args[]){
//        System.gc();
//        cutYear();
//        "11010111 0001 110001 110000 110000 110001 110101 110000 110000 110101 110001 110100 110000 110001 110010";
//        strToBinstr("51 10015 005 14012");
        substest();
    }

    public static void substest(){
        String str = "audit_status_desc";
        System.out.println(str.substring(0,str.length()-5));

    }
    public static void cutYear(){
        Calendar a = Calendar.getInstance();
        System.out.print( (a.get(Calendar.YEAR)+"").toString().substring(2));
    }

    // 将字符串转换成二进制字符串，以空格相隔
    private static String strToBinstr(String str) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += Integer.toBinaryString(strChar[i]) + " ";
        }
        System.out.println(result);
        return result;
    }
}
