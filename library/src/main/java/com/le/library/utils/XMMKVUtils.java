package com.le.library.utils;

import android.os.Parcelable;

import com.tencent.mmkv.MMKV;

/**
 * 基于 mmap 的高性能通用 key-value 组件
 */
public class XMMKVUtils {

    private static XMMKVUtils XMMKVUtils;

    private MMKV mmkv;

    private XMMKVUtils() {
        mmkv = MMKV.defaultMMKV();
    }

    public static XMMKVUtils getInstance() {
        if (XMMKVUtils == null) {
            synchronized (XMMKVUtils.class) {
                if (XMMKVUtils == null) {
                    XMMKVUtils = new XMMKVUtils();
                }
            }
        }
        return XMMKVUtils;
    }

    public void enCodeLong(String key, long value) {
        mmkv.encode(key, value);
    }

    public void enCodeString(String key, String value) {
        mmkv.encode(key, value);
    }

    public void enCodeBool(String key, boolean value) {
        mmkv.encode(key, value);
    }

    public void enCodeInt(String key, int value) {
        mmkv.encode(key, value);
    }

    public void enCodeParcelable(String key, Parcelable parcelable) {
        mmkv.encode(key, parcelable);
    }

    public int decodeInt(String key) {
        return mmkv.decodeInt(key, 0);
    }

    public long decodeLong(String key) {
        return mmkv.decodeLong(key, 0);
    }

    public String decodeString(String key) {
        return mmkv.decodeString(key, "");
    }

    public Boolean decodeBool(String key) {
        return mmkv.decodeBool(key, false);
    }

    public Parcelable decodeParcelable(String key) {
        return mmkv.decodeParcelable(key, null);
    }


}