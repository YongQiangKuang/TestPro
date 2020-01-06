package com.kyq.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * Created by duwanjiang on 2017/12/21.
 */
public class StringUtil {
    public static final Charset GB2312 = Charset.forName("GB2312");

    /**
     * 空对象判断
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null || obj.toString().trim().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 非空对象判断
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
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
     * 将字符串转码指定类型
     *
     * @param str
     * @param encodeType 编码类型
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encodingStr(String str, String encodeType) throws UnsupportedEncodingException {
        return new String(str.getBytes(), Charset.forName(encodeType));
    }

    /**
     * 将字符串转码为utf-8
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encodingUTF8(String str) throws UnsupportedEncodingException {
        return encodingStr(str, "utf-8");
    }

    /**
     * 将字符串转码为utf-8
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encodingGBK(String str) throws UnsupportedEncodingException {
        return encodingStr(str, "gbk");
    }

    /**
     * 根据分隔符合并List到字符串
     */
    public static String joinForSqlIn(List lstInput, String delim) {
        if (lstInput == null || lstInput.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (Iterator it = lstInput.iterator(); it.hasNext(); ) {
            sb.append("'").append(replaceBlank(it.next())).append("'");

            if (it.hasNext()) {
                sb.append(delim);
            }
        }

        return sb.toString();
    }

    /**
     * 重构字符串，如果为null，返回空串
     */
    public static String replaceBlank(Object obj) {
        if (isEmpty(obj)) {
            return "";
        } else {
            return obj.toString();
        }
    }


    /**
     * 重构字符串，如果为null，返回空串
     */
    public static String replaceNull(Object obj) {
        if (isEmpty(obj)) {
            return null;
        } else {
            return obj.toString();
        }
    }

    /**
     * 判断文件路径的斜杠是否是Java的分隔符
     *
     * @param filePath
     * @return
     */
    public static boolean isBackslash(String filePath) {
        if (StringUtil.isNotEmpty(filePath) && filePath.lastIndexOf("\\") > -1) {
            return true;
        }
        return false;
    }


    /**
     * 生成uuid
     *
     * @return uuid
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 正则表达式匹配两个指定字符串中间的内容
     */
    public static List<String> analizeResMsg(String soap, String rgex) {
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

    /**
     * 通过包名取时间字符串
     *
     * @param packageName
     * @return
     */
    public static String getDateByPackageName(String packageName) {
        if (isEmpty(packageName)) {
            return "";
        }
        String[] packageNameArr = packageName.split("_");
        return packageNameArr[packageNameArr.length - 1]
                .replace(".json", "")
                .replace(".zip", "");
    }

    /**
     * 通过json文件名获取id(120301_130301_1_201810130915.json -> 1)
     *
     * @param jsonFileName
     * @return
     */
    public static Long getIdByJsonFileName(String jsonFileName) {
        if (isEmpty(jsonFileName)) {
            return null;
        }
        String[] fileArr = jsonFileName.split("_");
        return Long.valueOf(fileArr[2]);
    }

    /**
     * 向左补齐字符
     *
     * @param str
     * @param len
     * @param param
     * @return
     */
    public static String PadLeft(String str, int len, String param) {
        if (str.length() < len) {
            String temp = "";
            for (int i = 0; i < (len - str.length()); i++) {
                temp += param;
            }
            return temp + str;
        } else {
            return str;
        }
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
        if (null == src) {
            throw new RuntimeException("padLeft处理字符串为null");
        }
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
     * 判断是否是主键冲突错误
     *
     * @param t
     * @return
     */
    public static boolean isUniqueConflict(Throwable t) {
        boolean flag = false;
        if (!(Objects.isNull(t) || Objects.isNull(t.getMessage()))) {
            if (t.getMessage().contains("重复键") || t.getMessage().contains("违反唯一约束条件") || t.getMessage().contains("unique constraint") || t.getMessage().contains("ORA-00001")) {
                flag = true;
            }
        }
        return flag;
    }


    public static String toHex(Long num, int len) {
        if (null == num) {
            return null;
        }
        if (num >= Math.pow(16, len)) {
            throw new RuntimeException("数字过大无法转成给定的长度");
        }
        char[] chs = new char[len];
        int index = chs.length - 1;
        for (int i = 0; i < len; i++) {
            Long temp = num & 15;

            if (temp > 9) {
                chs[index] = ((char) (temp - 10 + 'A'));
            } else {
                chs[index] = ((char) (temp + '0'));
            }

            index--;
            num = num >>> 4;
        }

        String temp = "";
        for (int i = 0; i < chs.length; i++) {
            temp = temp + chs[i];
        }
        return temp;
    }
}
