package com.kyq.test.schema;

import com.alibaba.fastjson.JSON;
import com.jfinal.kit.Kv;
import org.junit.Test;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author source
 * @date 2019/10/16 10:26
 */
public class Schema {

    @Test
    public void generatorSchema() throws IOException {
        String xlsPath = "C:\\Users\\31746\\Desktop\\1009\\otpiu.xlsx";
        String basePath = "C:\\Users\\31746\\Desktop\\1009";
        GeneratorSchema generatorSchema = new GeneratorSchema(xlsPath, basePath);
        generatorSchema.excelToReq();
//        generatorSchema.interfaceMapping();


    }


    @Test
    public void jsonSchema() {
        String json = " \n" +
                "        {\n" +
                "            \"id\": \"3\",\n" +
                "            \"pointType\": 1.12,\n" +
                "            \"laneNum\": \"1\",\n" +
                "            \"vehicleId\": \"默A00000_7\",\n" +
                "            \"tailVehicleId\": \"默A00000_7\",\n" +
                "            \"vehSpeed\":50,\n" +
                "            \"identifyType\": 1,\n" +
                "            \"vehFeatureCode\":\"20190101\",\n" +
                "            \"faceFeatureCode\":\"20190101\"\n" +
                "        }\n" ;
        Kv kv = JSON.parseObject(json,Kv.class);
        System.out.println((BigDecimal)kv.getAs("pointType"));

    }
}

