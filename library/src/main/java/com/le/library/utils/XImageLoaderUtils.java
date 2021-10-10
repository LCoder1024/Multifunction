package com.le.library.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.imageview.ShapeableImageView;
import com.makeramen.roundedimageview.RoundedImageView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 图片加载工具类
 */
public class XImageLoaderUtils {
    public static void loadImageView(ImageView imageView, String imageUrl, int placeholder) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholder)
                .error(placeholder)
                .dontAnimate();
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(imageView);
    }

    public static void loadImageView(ImageView imageView, String imageUrl, int placeholder, int error) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholder)
                .error(error)
                .dontAnimate();
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(imageView);
    }

    public static void loadShapeableImageView(ShapeableImageView imageView, String imageUrl, int placeholder) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholder)
                .error(placeholder)
                .dontAnimate();
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(imageView);
    }

    public static void loadShapeableImageView(ShapeableImageView imageView, String imageUrl, int placeholder, int error) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholder)
                .error(error)
                .dontAnimate();
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(imageView);
    }


    public static void loadRoundedImageView(RoundedImageView imageView, String imageUrl, int placeholder) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholder)
                .error(placeholder)
                .dontAnimate();
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(imageView);
    }

    public static void loadRoundedImageView(RoundedImageView imageView, String imageUrl, int placeholder, int error) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholder)
                .error(error)
                .dontAnimate();
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(imageView);
    }

    public static void loadCircleImageView(CircleImageView imageView, String imageUrl, int placeholder) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholder)
                .error(placeholder)
                .dontAnimate();
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(imageView);
    }

    public static void loadCircleImageView(CircleImageView imageView, String imageUrl, int placeholder, int error) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholder)
                .error(error)
                .dontAnimate();
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(imageView);
    }

}
