package com.kyq.test.io;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Description:
 * Copyright: ? 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2018-08-02 14:48
 */
public class Test {
    public static void main(String args[]){
        ByteBuffer encode = Charset.defaultCharset().encode("Hello World!");
        final ByteBuffer encode1 = Charset.forName("UTF-8").encode("Hello World!");


    }
}
