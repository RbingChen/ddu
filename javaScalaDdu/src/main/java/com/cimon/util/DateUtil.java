package com.cimon.util;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static DateFormat getDateFormat(String format){
        return new SimpleDateFormat(format);
    }
    public static DateFormat getDateFormat(){
        return getDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * input :yyyy-mm-dd HH:mm:ss 格式的字符串
     * output : unixstamp 时间戳 ms
     * */
    public static long Date2Timestamp(String ts){
        Timestamp timestamp = Timestamp.valueOf(ts);
        return timestamp.getTime();
    }
    /**
     * 输入是ms
     * */
    public static String timestamp2Date(Long ts){
        Timestamp timestamp = new Timestamp(ts);
        return getDateFormat().format(timestamp);
    }
    /**
     * 从时间戳中获取到 一天的小时
     * */
    public static int getHourFromTs(Long ts){
        Date date = new Date(ts);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.HOUR_OF_DAY;
    }
    /**
     * 从时间戳中获取到 小时的分钟
     * */
    public static int getMinuteFromTs(Long ts){
        Date date = new Date(ts);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.MINUTE;
    }

    /**
     * 日期 增减天数
     * */
    public static String addDays(Long ts,int day){
        Date date = new Date(ts);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // set的是Date类
        calendar.add(Calendar.DAY_OF_YEAR,day);
        return getDateFormat().format(calendar.getTime()); // get的也是Date类
    }
    /**
     * 输入格式,默认yyyy-MM-dd
     * */
    public static String addDays(String date,int day) throws ParseException{

        String format = "yyyy-MM-dd";
        return addDays(date,day,format);
    }
    public static String addDays(String dt,int day, String format ) throws ParseException {
        Date date = getDateFormat(format).parse(dt);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // set的是Date类
        calendar.add(Calendar.DAY_OF_YEAR,day);
        return getDateFormat(format).format(calendar.getTime()); // get的也是Date类
    }

    /**
     * 生成日期范围
     * */

}
