package com.kyq.test.schema;

import cn.hutool.core.util.ReUtil;
import com.jfinal.kit.Okv;
import com.kyq.test.util.MathUtil;

import java.util.function.Consumer;

/**
 * @author source
 * @date 2019/9/23 11:12
 */
@SuppressWarnings("warn")
public enum PropertiesEnum {

    YYYY_MM_DDTHH_mm_ss("", "String", "", "YYYY-MM-DDTHH:mm:ss", okv -> {
        okv.set("type", "string").set("pattern", "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)(T)(0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1})$");
    }),
    YYYY_MM_DD("", "String", "", "YYYY-MM-DD", okv -> {
        okv.set("type", "string").set("pattern", "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$");
    }),
    YYYYMMDDHHMMSS("", "String", "", "YYYYMMDDHHMMSS", okv ->  {
        okv.set("type", "string").set("pattern", "^(?:(?!0000)[0-9]{4}(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30)|(?:0[13578]|1[02])31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)0229)(0\\d{1}|1\\d{1}|2[0-3])[0-5]\\d{1}([0-5]\\d{1})$");
    }),
    YYYYMMDDHHMM("", "String", "", "YYYYMMDDHHMM", okv -> {
        okv.set("type", "string").set("pattern", "^(?:(?!0000)[0-9]{4}(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30)|(?:0[13578]|1[02])31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)0229)(0\\d{1}|1\\d{1}|2[0-3])[0-5]\\d{1}$");
    }),
    YYYYMMDDHH("", "String", "", "YYYYMMDDHHMM", okv -> {
        okv.set("type", "string").set("pattern", "^(?:(?!0000)[0-9]{4}(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30)|(?:0[13578]|1[02])31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)0229)(0\\d{1}|1\\d{1}|2[0-3])$");
    }),
    YYYYMMDD("", "String", "", "YYYYMMDDHHMM", okv -> {
        okv.set("type", "string").set("pattern", "^(?:(?!0000)[0-9]{4}(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30)|(?:0[13578]|1[02])31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)0229)$");
    }),
    MAXLENGTH("", "String", "", "不超过|长度", okv -> {
        okv.set("type", "string").set("maxLength", MathUtil.asInteger(ReUtil.findAll("[0-9]+", okv.getStr("description"), 0).get(0)));
    }),
    VEHICLEID("VEHICLEID", "String", "", "", okv -> {
        okv.set("type", "string").set("pattern", "^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z0-9]{1}[A-Z0-9]{1}([京津沪渝桂蒙宁新藏冀晋辽吉黑苏浙皖赣闽鲁粤鄂湘豫川云贵陕甘青琼])?[A-NP-Z0-9]{1}[A-NP-Z0-9]{3}([A-NP-Z0-9挂学警港澳领试超外]{1}|应急)([A-NP-Z0-9外])?_(0|1|2|3|4|5|6|7|11|12))$|^(([A-Z0-9]{7})_(0|1|2|3|4|5|6|7|11|12))$|^默A00000_7$|^(应急[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z0-9]{1}[A-NP-Z0-9]{4}_(0|1|2|3|4|5|6|7|11|12))$");
    }),
    VEHICLEPLATE("", "String", "", "VEHICLEPLATE", okv -> {
        okv.set("type", "string").set("pattern", "^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z0-9]{1}[A-Z0-9]{1}([京津沪渝桂蒙宁新藏冀晋辽吉黑苏浙皖赣闽鲁粤鄂湘豫川云贵陕甘青琼])?[A-NP-Z0-9]{1}[A-NP-Z0-9]{3}([A-NP-Z0-9挂学警港澳领试超外]{1}|应急)([A-NP-Z0-9外])?)$|^([A-Z0-9]{7})$|^默A00000$|^(应急[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z0-9]{1}[A-NP-Z0-9]{4})$");
    }),
    INTEGERENUM("", "Integer|Interger", "", "-", okv -> {
        String description = okv.getStr("description");
        int[] ints = ReUtil.findAll("[0-9]+", description, 0).stream().mapToInt(MathUtil::asInteger).sorted().distinct().toArray();
        okv.set("type", "integer").set("enum", ints);
    }),
    INTEGERBETWEEN("", "Integer|Interger", "", "大于|小于", okv -> {
        okv.set("type", "integer");
        String description = okv.getStr("description");
        if (description.contains("大于等于0") || description.contains("大于0")) {
            okv.set("minimum", 0);
        }
        if (description.contains("大于等于1")) {
            okv.set("minimum", 1);
        }
        if (description.contains("小于等于1000")) {
            okv.set("maximum", 1000);
        }
    }),
    NUMBERBETWEEN("", "Long|Double", "", "大于|小于", okv -> {
        okv.set("type", "number");
        String description = okv.getStr("description");
        if (description.contains("大于等于0") || description.contains("大于0")) {
            okv.set("minimum", 0);
        }
        if (description.contains("大于等于1")) {
            okv.set("minimum", 1);
        }
        if (description.contains("小于等于1000")) {
            okv.set("maximum", 1000);
        }
    }),
    STRING("", "String", "", "", okv -> {
        okv.set("type", "string");
    }),
    INTEGER("", "Integer|Interger", "", "", okv -> {
        okv.set("type", "integer");
    }),
    NUMBER("", "Long|Double", "", "", okv -> {
        okv.set("type", "number");
    });


    private String id;
    private String type;

    private String title;
    private String description;
    private Consumer<Okv> consumer;

    PropertiesEnum(String id, String type, String title, String description, Consumer<Okv> consumer) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.consumer = consumer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Consumer<Okv> getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer<Okv> consumer) {
        this.consumer = consumer;
    }
}
