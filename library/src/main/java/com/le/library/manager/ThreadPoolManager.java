package com.le.library.manager;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池管理类
 */
public final class ThreadPoolManager extends ThreadPoolExecutor {

    private static volatile ThreadPoolManager sInstance;

    public ThreadPoolManager() {
        super(0, Integer.MAX_VALUE,
                30L, TimeUnit.SECONDS,
                new SynchronousQueue<>());
    }

    public static ThreadPoolManager getInstance() {
        if (sInstance == null) {
            synchronized (ActivityManager.class) {
                if (sInstance == null) {
                    sInstance = new ThreadPoolManager();
                }
            }
        }
        return sInstance;
    }
}