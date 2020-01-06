package com.kyq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 *
 * @author cloud
 * @date 2017/12/12
 */
public class DateUtil {

    /**
     * 精确地3位毫秒
     */
    public static final String format_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    /**
     * 精确地0位毫秒
     */
    public static final String format_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    /**
     * 精确到天
     */
    public static final String format_yyyy_MM_dd = "yyyy-MM-dd";
    /**
     * 精确到天
     */
    public static final String format_yyyyMMdd = "yyyyMMdd";

    /**
     * 精确到小时
     * */
    public static final String format_yyyyMMddHH = "yyyyMMddHH";

    /**
     * 精确地3位毫秒
     */
    public static final String format_yyyy_MM_dd_HHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 精确地0位毫秒
     */
    public static final String format_yyyy_MM_ddTHHmmss = "yyyy-MM-dd'T'HH:mm:ss";
    /**
     * 精确地0位毫秒
     */
    public static final String format_yyyy_MM_dd_HHmmss = "yyyy-MM-dd HH:mm:ss";
    /**
     * 不用日期
     */
    public static final String format_HHmmss = "HH:mm:ss";
    /**
     * yyyy/MM/dd的时间路径
     */
    public static final String format_yyyy_MM_dd_path = "yyyy/MM/dd";

    /**
     * 时区东八区
     */
    public static final String format_GMT_8 = "GMT+8";

    /**
     * 格式化日期对象
     *
     * @param date   日期对象
     * @param format 格式化字符串
     * @return
     */
    public static String formatDate(Date date, String format) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date == null) {
            throw new NullPointerException("格式化时间对象不能为null!");
        } else {
            result = sdf.format(date);
        }
        return result;
    }

    /**
     * 获取当前的时间yyyyMMddHHmmssSSS
     *
     * @return
     */
    public static String getCurrentTime_yyyyMMddHHmmssSSS() {
        return formatDate(new Date(), format_yyyyMMddHHmmssSSS);
    }

    /**
     * 获取当前的时间format_yyyy_MM_ddTHHmmss
     *
     * @return
     */
    public static String getCurrentTime_format_yyyy_MM_ddTHHmmss() {
        return formatDate(new Date(), format_yyyy_MM_ddTHHmmss);
    }

    /**
     * 格式化日期对象
     *
     * @param date   日期对象
     * @param format 格式化字符串
     * @return
     */
    public static Date parseDate(String date, String format) {
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null && !("".equals(date))) {
            try {
                result = sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 获取时间差
     *
     * @param startTime 开始时间（date）
     * @param endTime   结束时间（date）
     * @return
     */
    public static String diffTime(Date startTime, Date endTime) {
        return diffTime(startTime.getTime(), endTime.getTime());
    }

    /**
     * 获取时间差
     *
     * @param startTimeStamp 开始时间戳
     * @param endTimeStamp   结束时间戳
     * @return
     */
    public static String diffTime(long startTimeStamp, long endTimeStamp) {
        String result = "";
        long diff = endTimeStamp - startTimeStamp;
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = diff / (1000 * 60 * 60) - days * 24;
        long mins = diff / (1000 * 60) - hours * 60;
        long seconds = diff / (1000) - mins * 60;
        if (days > 0) {
            result += days + "天";
        }
        if (hours > 0) {
            result += hours + "小时";
        }
        if (mins > 0) {
            result += mins + "分";
        }
        if (seconds > 0) {
            result += seconds + "秒";
        }
        if (StringUtil.isEmpty(result)) {
            result = diff + "毫秒";
        }
        return result;
    }

    /**
     * 获取时间毫秒差
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static Long getTimes(Date startTime, Date endTime) {
        return endTime.getTime() - startTime.getTime();
    }

    /**
     * 获取两个时间之间的天数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffDays(Date startTime, Date endTime) {
        long result = 0;
        long diff = endTime.getTime() - startTime.getTime();
        result = diff / (1000 * 60 * 60 * 24);
        return result;
    }

    /**
     * 获取两个时间之间的小数数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffHours(Date startTime, Date endTime) {
        long result = 0;
        long diff = endTime.getTime() - startTime.getTime();
        result = diff / (1000 * 60 * 60);
        return result;
    }

    /**
     * 日期月份计算
     *
     * @param startDate   基础日期
     * @param monthAmount 增加或减去的月份数
     * @return 返回增加或减去指定月份数后的日期
     */
    public static Date addMonth(Date startDate, int monthAmount) {
        return addTime(startDate, monthAmount, Calendar.MONTH);
    }

    /**
     * 日期月份计算
     *
     * @param startDate   基础日期
     * @param monthAmount 增加或减去的月份数
     * @return 返回增加或减去指定月份数后的日期
     */
    public static Date addDays(Date startDate, int monthAmount) {
        return addTime(startDate, monthAmount, Calendar.DATE);
    }

    /**
     * 日期计算
     *
     * @param date   基础日期
     * @param amount 天数或月数或年数...
     * @param field  需要计算的值:Calendar.MONTH,Calendar.YEAR,Calendar.DATE,Calendar.WEDNESDAY
     * @return 返回计算后的日期
     */
    public static Date addTime(Date date, int amount, int field) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, amount);
        return cal.getTime();
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss 格式的时间
     * @param date
     * @return
     */
    public static String getFormatTime(Date date) {
        return formatDate(date, format_yyyy_MM_dd_HHmmss);
    }

    /**
     * 是否一个月最后一天
     * @param date
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, Calendar.DAY_OF_MONTH);
        return calendar.get(Calendar.DAY_OF_MONTH) == 1;
    }

    public static Date toDay(Date date) {
        return parseDate(formatDate(date, format_yyyy_MM_dd), format_yyyy_MM_dd);
    }

    public static boolean isEquals(Date x, Date y, Integer ... args) {
        Calendar calendarX = Calendar.getInstance();
        calendarX.setTime(x);
        Calendar calendarY = Calendar.getInstance();
        calendarY.setTime(y);

        if (args == null || args.length == 0) {
            return calendarX.equals(calendarY);
        }

        List<Integer> list = Arrays.asList(args);

        if (list.contains(Calendar.YEAR)) {
            if (calendarX.get(Calendar.YEAR) != calendarY.get(Calendar.YEAR)) {
                return false;
            }
            if (list.contains(Calendar.MONTH)) {
                if (calendarX.get(Calendar.MONTH) != calendarY.get(Calendar.MONTH)) {
                    return false;
                }
                if (list.contains(Calendar.DAY_OF_MONTH)) {
                    if (calendarX.get(Calendar.DAY_OF_MONTH) != calendarY.get(Calendar.DAY_OF_MONTH)) {
                        return false;
                    }
                    if (list.contains(Calendar.HOUR_OF_DAY)) {
                        if (calendarX.get(Calendar.HOUR_OF_DAY) != calendarY.get(Calendar.HOUR_OF_DAY)) {
                            return false;
                        }
                        if (list.contains(Calendar.MINUTE)) {
                            if (calendarX.get(Calendar.MINUTE) != calendarY.get(Calendar.MINUTE)) {
                                return false;
                            }
                            if (list.contains(Calendar.SECOND)) {
                                if (calendarX.get(Calendar.SECOND) != calendarY.get(Calendar.SECOND)) {
                                    return false;
                                }
                                if (list.contains(Calendar.MILLISECOND)) {
                                    return calendarX.get(Calendar.MILLISECOND) != calendarY.get(Calendar.MILLISECOND);
                                }
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }


}
