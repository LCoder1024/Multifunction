package com.le.library.utils;

import java.math.BigDecimal;

public class XArithmeticUtils {

    /**
     * 两个Double数相加
     *
     * @param v1 Double 1
     * @param v2 Double 2
     * @return Double 相加
     */
    public static Double add(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.add(b2).doubleValue();
    }

    /**
     * 两个Double数相减
     *
     * @param v1 Double 1
     * @param v2 Double 2
     * @return Double 相减
     */
    public static Double sub(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 两个Double数相乘
     *
     * @param v1 Double 1
     * @param v2 Double 2
     * @return Double 相乘
     */
    public static Double mul(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 两个Double数相除
     *
     * @param v1 Double 1
     * @param v2 Double 2
     * @return Double 相除
     */
    public static Double div(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 两个Double数相除，并保留scale位小数
     *
     * @param v1    Double 1
     * @param v2    Double 2
     * @param scale 小数点后的位数、大于0
     * @return Double
     */
    public static Double div(Double v1, Double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
