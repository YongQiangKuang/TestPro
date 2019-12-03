package com.kyq.test.common;

import org.junit.Test;

import javax.print.*;
import javax.print.attribute.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        System.out.println(String.format("%02d",33));

        String str = "1|2|3||5";
        String[] strArr = str.split("\\|");
//        List list =new ArrayList(Arrays.asList(strArr));
        List list = new LinkedList();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
//        list.add(1,12);

        int len = list.size();
        for(int i=0; i < len; i++){
            if(i==2){
                list.addAll(i,Arrays.asList(strArr));
                len+=strArr.length;
            }
            System.out.print(list.get(i)+",");
        }
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        test(list);
        System.out.println(list);
//        testPrinter();
//        testDivide();
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

//        Map map = new HashMap(){
//            {put("病假",1);}
//            {put("产假",2);}
//        };
//        List list = (List) map.entrySet().stream().map(x->{
//            Map out = new HashMap<>();
//            out.put("name",((Map.Entry) x).getKey());
//            out.put("value",((Map.Entry) x).getValue());
//            return out;
//        }).collect(Collectors.toList());
//        System.out.println(list);
    }
    public static void test(List list){
        List ret = new ArrayList();
        ret.add("t1");
        list = ret;
    }
    public static void testPrinter(){
        DocFlavor flavor = DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;
//        flavor = new DocFlavor.INPUT_STREAM("application/octet-stream; charset=UTF-8");
        HashDocAttributeSet pras = new HashDocAttributeSet();
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(flavor,pras);

        System.out.println(1);
        System.setProperty("jna.encoding", "UTF-8");
        System.setProperty("file.encoding", "UTF-8");
//        for(PrintService service : printServices){
//            if(service.getName().contains("M701n")){
//                System.out.println(service.getName());
//                System.out.println(DocFlavor.hostEncoding);
//                print(service);
//            }
//        }

        PrintService service1 = PrintServiceLookup.lookupDefaultPrintService();
        Class<?>[] supportedAttributeCategories = service1.getSupportedAttributeCategories();
        DocFlavor[] supportedDocFlavors = service1.getSupportedDocFlavors();
        System.out.println(1);

//        print(service1);
    }
    public static void print(PrintService service){
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        try {
            DocPrintJob printJob = service.createPrintJob();
//            DocFlavor[] supportedDocFlavors = printJob.getPrintService().getSupportedDocFlavors();
            Doc doc = new SimpleDoc(new FileInputStream(new File("D:\\workdocument\\加班生活费\\加班生活费记录.xlsx")),flavor, null);
            printJob.print(doc,  new HashPrintRequestAttributeSet());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (PrintException e) {
            e.printStackTrace();
        }
    }

    public static void testDivide(){
        Integer i = 20;
        for (int k=0;k<i;k++){
            System.out.println("i(i/10):"+(i/10));
        }
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

    @Test
    public void testSub(){
        System.out.println("S010150006000810".substring(14,15));
    }
}
