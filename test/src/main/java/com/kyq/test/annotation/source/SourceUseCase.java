package com.kyq.test.annotation.source;

/**
 * Description:
 * Copyright: © 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2017-12-10 17:58
 */
@SourceAnnotationEx(source="ExSource")
public class SourceUseCase {
    private void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }
}
