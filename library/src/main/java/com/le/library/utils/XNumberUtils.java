package com.le.library.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 数字工具类
 */
public class XNumberUtils {
    public static String PATTERN2 = "0.00";
    public static String PATTERN5 = "0.00000";
    public static String PATTERN6 = "0.000000";

    /**
     * 四舍五入
     *
     * @param number  原始数据
     * @param scale   保留位数
     * @param pattern 模式
     * @return 四舍五入并且保留scale位后的数据
     */
    public static String getRoundHalfUp(double number, int scale, String pattern) {
        if (XStringUtils.isEmpty(String.valueOf(number))) {
            return pattern;
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(number);
        double doubleValue = bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(doubleValue);
    }

    /**
     * 四舍五入
     *
     * @param number  原始数据
     * @param scale   保留位数
     * @param pattern 模式
     * @return 四舍五入并且保留scale位后的数据
     */
    public static String getRoundHalfUp(String number, int scale, String pattern) {
        if (XStringUtils.isEmpty(number)) {
            return pattern;
        }
        BigDecimal bigDecimal = new BigDecimal(number);
        double doubleValue = bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(doubleValue);
    }
}
