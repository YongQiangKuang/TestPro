package com.kyq.test.annotation.runtime;

/**
 * Description:
 * Copyright: © 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2017-12-10 22:19
 */
@RuntimeAnnotationEx("ExRuntime")
public class TestRuntimeMain {
    public static void main(String args[]){
        RuntimeAnnotationEx annotationEx = TestRuntimeMain.class.getAnnotation(RuntimeAnnotationEx.class);
        System.out.println(annotationEx.value());
    }
}
