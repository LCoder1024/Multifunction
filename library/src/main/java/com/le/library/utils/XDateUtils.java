package com.le.library.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 */
@SuppressLint( "SimpleDateFormat" )
public class XDateUtils {
    public static String PATTERN_YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static String PATTERN_YMD_HM = "yyyy-MM-dd HH:mm";
    public static String PATTERN_YMD = "yyyy-MM-dd";

    /**
     * 时间戳转换成日期格式
     *
     * @param timestamp 时间戳
     * @param pattern   日期格式
     * @return 日期格式
     */
    public static String getTimestampFormat(String timestamp, String pattern) {
        if (XStringUtils.isEmpty(timestamp)) {
            return "";
        }
        long times;
        if (XStringUtils.is10Places(timestamp)) {
            times = Long.parseLong(timestamp) * 1000L;
        } else if (XStringUtils.is13Places(timestamp)) {
            times = Long.parseLong(timestamp);
        } else {
            times = 0;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date(times));
    }

}
