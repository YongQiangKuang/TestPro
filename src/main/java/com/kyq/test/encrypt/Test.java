package com.kyq.test.encrypt;

import com.github.cheergoivan.totp.TOTPAuthenticator;
import io.netty.handler.codec.base64.Base64;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Description:
 * Copyright: © 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2018-07-10 14:09
 */
public class Test {
    public static void main(String args[]) throws UnsupportedEncodingException {
//            String key = CryptHelper.encode("977069".getBytes("UTF8"));
//            System.out.println(key);
//            String key = CryptHelper.encode("sysadmin".getBytes("UTF8"));
//            System.out.println(key);
//===
//        String otp = CryptHelper.getTOTP("KNRUO42KIRUU4VDFKJTECY2FEE","sysadmin");
//        System.out.println(otp);
//        boolean v = CryptHelper.verifyTOTP("sysadmin",otp);
//        System.out.println(v);
//        System.out.println(new String(CryptHelper.decode("NBCWYTDPK5XVE3CEEE")));
        System.out.println(new String(CryptHelper.decode("KNRUO42KIRUU4VDFKJTECY2FEE")));
        String key1 = CryptHelper.encode("sCgSDsj".getBytes("UTF8"));
        String key2 = key1+"iAutORhIzAtoIn!";
        System.out.println(CryptHelper.encode(key2.getBytes("UTF8")));
        System.out.println(new String(CryptHelper.decode("INTERFACE")));
        //====
        //KNRUO42KIRUU4VDFKJTECY2FEE
        //GSNT44D7Q2O72EC6
//        org.apache.commons.codec.binary.Base64 codec64 = new org.apache.commons.codec.binary.Base64();
//        System.out.println(new String(codec64.decode("GSNT44D7Q2O72EC6")));
//        testGit();
    }

    public static void testGit(){
        TOTPAuthenticator au = TOTPAuthenticator.builder().timeStepSize(60).build();
        try {
            String key = au.generateTOTP(CryptHelper.encode("sysadmin".getBytes("UTF8")));
            System.out.println(key);

            boolean v = au.validateTOTP(CryptHelper.encode("sysadmin".getBytes("UTF8")),"872819");
            System.out.println(v);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
