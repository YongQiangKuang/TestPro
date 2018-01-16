package com.kyq.test.annotation.runtime;

/**
 * Description:
 * Copyright: © 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2017-12-10 21:54
 */
@RuntimeAnnotationEx("ExRuntime")
public class RuntimeUseCase {
    private void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }
}
