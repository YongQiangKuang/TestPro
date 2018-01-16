package com.kyq.test.annotation.classes;


/**
 * Description:
 * Copyright: © 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2017-12-10 17:58
 */
@ClassAnnotationEx(value="ExClass")
public class ClassUseCase {
    private void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }
}
