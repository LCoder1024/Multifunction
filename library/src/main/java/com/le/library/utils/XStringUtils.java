package com.le.library.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 工具类
 */
public class XStringUtils {

    /**
     * 字符串的处理，为空时默认返回空字符串
     *
     * @param str 待校验的字符串
     * @return 待校验字符串不为空时返回原字符串/为空时返回空字符串
     */
    public static String getStrEmpty(@Nullable String str) {
        if (str != null && !TextUtils.isEmpty(str) &&
                !str.equalsIgnoreCase("null") && !("").equals(str)) {
            return str;
        }
        return "";
    }

    /**
     * 字符串的处理，为空时默认返回0
     *
     * @param str 待校验的字符串
     * @return 待校验字符串不为空时返回原字符串/为空时返回0
     */
    public static String getDefaultZeroNumber(String str) {
        if (str != null && !TextUtils.isEmpty(str) &&
                !str.equalsIgnoreCase("null") && !("").equals(str)) {
            return str;
        }
        return "0";
    }

    /**
     * 字符串的处理，为空时默认返回1
     *
     * @param str 待校验的字符串
     * @return 待校验字符串不为空时返回原字符串/为空时返回1
     */
    public static String getDefaultOneNumber(String str) {
        if (str != null && !TextUtils.isEmpty(str) &&
                !str.equalsIgnoreCase("null") && !("").equals(str)) {
            return str;
        }
        return "1";
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 待校验的字符串
     * @return 空为true、非空为false
     */
    public static boolean isEmpty(String str) {
        return getStrEmpty(str).equals("");
    }

    /**
     * 判断两个字符串是否相等
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 相等为true、不相等为false
     */
    public static boolean isEquals(String str1, String str2) {
        if (isEmpty(str1) || isEmpty(str2)) {
            return false;
        }
        return str1.equals(str2);
    }

    /**
     * 版本号比较 (0代表相等,1代表左边大,-1代表右边大)
     *
     * @param v1 服务器版本号
     * @param v2 本地版本号
     * @return 0(相等) 1(服务器版本号高) -1(本地版本号高)
     */
    public static int getCompareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] version1Array = v1.split("[._]");
        String[] version2Array = v2.split("[._]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;
        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }
            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    /**
     * 版本号名称 (1.0)
     *
     * @param context 上下文
     * @return 版本号
     */
    public static String getVersionName(Context context) {
        AtomicReference<String> versionName = new AtomicReference<>("");
        try {
            versionName.set(context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName.get();
    }

    /**
     * 字符串长度是否在6到20位[6,20]
     *
     * @param str 待校验的字符串
     * @return 符合true、不符合false
     */
    public static boolean is6to20Places(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return str.matches("^.{6,20}$");
    }

    /**
     * 判断是否是6位
     *
     * @param str 待校验字符串
     * @return 是 true 否 false
     */
    public static boolean is6Places(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return str.matches("^\\d{6}$");
    }

    /**
     * 判断是否是10位
     *
     * @param str 待校验字符串
     * @return 是 true 否 false
     */
    public static boolean is10Places(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return str.matches("^\\d{10}$");
    }

    /**
     * 判断是否是11位
     *
     * @param str 待校验字符串
     * @return 是 true 否 false
     */
    public static boolean is11Places(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return str.matches("^\\d{11}$");
    }

    /**
     * 判断是否是13位
     *
     * @param str 待校验字符串
     * @return 是 true 否 false
     */
    public static boolean is13Places(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return str.matches("^\\d{13}$");
    }


    /**
     * 隐藏手机号中间4位
     *
     * @param phone 手机号
     * @return 手机号中间四位用*号代替
     */
    public static String setPhone(String phone) {
        if (!is11Places(phone) && isEmpty(phone)) {
            return phone;
        }
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }


}
