package com.le.library.utils;

import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;

/**
 * 动态设计view宽高的工具类
 */
public class XMeasureUtils {

    /**
     * 根据设计图的宽高动态计算view的宽和高、宽高相等并且宽高为屏幕的宽度
     *
     * @param view view
     */
    public static void layoutWHParams(View view) {
        int widths = getWidth();
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = widths;
        params.height = widths;
        view.setLayoutParams(params);
    }

    /**
     * 根据设计图的宽高动态计算view的宽和高、宽高相等并且宽高为屏幕的宽度-屏幕间距的总宽度
     *
     * @param view   view
     * @param margin 距离屏幕的间距 dp
     */
    public static void layoutWHParams(View view, int margin) {

        int wh = getWidth() - SizeUtils.dp2px(margin);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = wh;
        params.height = wh;
        view.setLayoutParams(params);
    }

    /**
     * 根据设计图的宽高动态计算view的宽和高
     *
     * @param view   view
     * @param margin 每个view之间的间距的总和（单位为dp）
     * @param column 将屏幕分成多少列
     */
    public static void layoutWHParams(View view, int margin, int column) {

        int wh = (getWidth() - SizeUtils.dp2px(margin)) / column;
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = wh;
        params.height = wh;
        view.setLayoutParams(params);
    }

    /**
     * 根据设计图的宽高动态计算view的宽和高
     *
     * @param view   view
     * @param margin 距离屏幕的间距 dp
     * @param width  设计图中view的宽
     * @param height 设计图中view的高
     */
    public static void layoutWHParams(View view, int margin, int width, int height) {
        int width1 = getWidth() - SizeUtils.dp2px(margin);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width1;
        params.height = width1 * height / width;
        view.setLayoutParams(params);
    }

    /**
     * 根据设计图的宽高动态计算view的宽和高
     *
     * @param view   view
     * @param margin 距离屏幕的间距和 dp
     * @param column 将屏幕分成多少列
     * @param width  设计图中view的宽
     * @param height 设计图中view的高
     */
    public static void layoutWHParams(View view, int margin, int column, int width, int height) {
        int wh = (getWidth() - SizeUtils.dp2px(margin)) / column;
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = wh;
        params.height = wh * height / width;
        view.setLayoutParams(params);
    }

    public static int getWidth() {
        return ScreenUtils.getScreenWidth();
    }

}
