package com.kyq.test.common;

import net.dongliu.requests.RawResponse;
import net.dongliu.requests.Requests;
import net.dongliu.requests.body.Part;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Copyright: © 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2018-06-15 10:29
 */
public class RequestsTest {
    public static void main(String args[]){
        new RequestsTest().request();
    }

    public void request(){
        String url = "http://localhost:8080/controller/json.action";
        Map params = new HashMap<>();
        params.put("actionName","complaint-external-query");
        params.put("postData","{}");
        params.put("start",1);
        params.put("limit",5);


//        Requests.post(url)
//                .multiPartBody(
//                        Part.file("uploadFile",new File("C:\\Users\\kyq1024\\Desktop\\work\\sign1.png")),
//                        Part.file("uploadFile",new File("C:\\Users\\kyq1024\\Desktop\\work\\sign2.png")),
//                        Part.text("actionName","complaint-external-query"),
//                        Part.text("postData","{}")
//                ).send();

        RawResponse send = Requests.post(url).body(params).send();
        String resp = send.readToText();
        System.out.println(resp);
    }
}
