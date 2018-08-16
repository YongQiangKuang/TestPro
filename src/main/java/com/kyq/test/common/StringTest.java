package com.kyq.test.common;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
        String as[] = new String[]{"aaa","nnn"};
        Arrays.asList(as);
        System.out.println();

//        System.gc();
//        cutYear();
//        "11010111 0001 110001 110000 110000 110001 110101 110000 110000 110101 110001 110100 110000 110001 110010";
//        strToBinstr("51 10015 005 14012");
//        substest();
//        Timestamp timestamp = Timestamp.valueOf("2018-06-28 17:27:58.000000");
//        System.out.println(timestamp);
//        String s = "aaaa,aaaa";
//        String t[] = s.split(",");
//        System.out.println(new HashSet<>().add(""));
//        Long l = new Long(1521);
//        long s = 2312L;
//        System.out.println(l+"");
//        System.out.println(s+"");
//        testVolatile();
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

    private static void testVolatile(){
        List array = new ArrayList<>();
        for(int i=0;i<100000;i++){
            array.add(i);
        }
        AtomicInteger a = new AtomicInteger(0);
        long startA = System.currentTimeMillis();
        array.stream().forEach(x->a.incrementAndGet());
        long endA = System.currentTimeMillis();

        AtomicInteger b = new AtomicInteger(0);
        long startB = System.currentTimeMillis();
        array.parallelStream().forEach(x->b.incrementAndGet());
        long endB = System.currentTimeMillis();
        System.out.println("a:"+a.get()+"  cost:"+(endA-startA));
        System.out.println("b:"+b.get()+"  cost:"+(endB-startB));

    }
}
