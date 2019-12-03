package com.kyq.test.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.jfinal.kit.StrKit;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author source
 * @date 2019/9/24 19:49
 */
public class StringUtil {

    /**
     * 请求数据格式 split标识
     */
    public static final String RECEIVE_MSG_SPLIT = ";;";
    public static final String UTF8STR = "UTF-8";
    public static final Charset UTF8 = StandardCharsets.UTF_8;
    public static final Charset GB2312 = Charset.forName("GB2312");

    /**
     * 空对象判断 如果多个对象其中有一个为空，那么返回true
     *
     * @param objs 所有的对象
     * @return 是否为空
     */
    public static boolean isEmpty(Object... objs) {
        for (Object o : objs) {
            if (o == null || "".equals(o.toString().trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断json字符串是否有效
     *
     * @param jsonString 需验证字符串
     * @return 源字符串
     */
    public static String validJson(String jsonString) {
        if (JSON.isValid(jsonString)) {
            return jsonString;
        } else {
            throw new RuntimeException("解析报文体json文本失败");
        }
    }


    public static boolean isMatchCaseInsensitiveIn(String regex, CharSequence content) {
        if (content == null) {
            return false;
        } else if (StrKit.isBlank(regex)) {
            return true;
        } else {
            return isMatch(Pattern.compile(".*(" + regex + ").*", Pattern.CASE_INSENSITIVE), content);
        }
    }

    private static boolean isMatch(Pattern pattern, CharSequence content) {
        return (content != null && pattern != null) && pattern.matcher(content).matches();
    }

    /**
     * 左填充字符
     *
     * @param src
     * @param len
     * @param ch
     * @return
     */
    public static String padLeft(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }
        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    /**
     * 右填充字符
     *
     * @param src
     * @param len
     * @param ch
     * @return
     */
    public static String padRight(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }
        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }


    /**
     * 格式化json文本
     *
     * @param json
     * @return
     */
    public static String formatJsonStr(String json) {
        if (StrKit.isBlank(json)) {
            return json;
        }
        JSONObject jsonObject = JSONObject.parseObject(json, Feature.OrderedField);
        return JSONObject.toJSONString(jsonObject, true);
    }

    /**
     * 判断是否是主键冲突错误
     *
     * @param t
     * @return
     */
    public static boolean isUniqueConflict(Throwable t) {
        boolean flag = false;
        if (!(Objects.isNull(t) || Objects.isNull(t.getMessage()))) {
            if (t.getMessage().contains("重复键") || t.getMessage().contains("违反唯一约束条件")) {
                flag = true;
            }
        }
        return flag;
    }
    /**
     * 判断是否包含元素
     *
     * @param array
     * @param str
     * @return
     */
    public static boolean isContained(String[] array, String str) {
        if (isEmpty(str)) {
            return false;
        }
        if (array == null) {
            return false;
        }
        for (String temp : array) {
            if (temp.equals(str)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 非空对象判断
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object... obj) {
        return !isEmpty(obj);
    }
}
