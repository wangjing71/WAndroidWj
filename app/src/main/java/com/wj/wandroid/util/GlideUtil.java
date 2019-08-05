package com.wj.wandroid.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.wj.wandroid.R;

/**
 * author wangjing
 * Date 2018/11/20
 * Description
 */
public class GlideUtil {

    //有默认加载中图片的方法
    public static void loadImageDefault(Context context, String url, final ImageView iv) {
        if (context == null) {
            return;
        }
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if(((Activity)context).isDestroyed()){
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    //最简单的加载方法
    public static void load(Context context, String url, final ImageView iv) {
        if (context == null) {
            return;
        }
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if(((Activity)context).isDestroyed()){
            return;
        }
        Glide.with(context)
                .load(url)
                .into(iv);
    }

    //加载图片标准方法可用于异步加载图片
    public static void loadImageAnsy(Context context, String url, ImageView iv) {
        if (context == null) {
            return;
        }
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if(((Activity)context).isDestroyed()){
            return;
        }
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    //可以自己设置加载的时候显示的图片
    public static void loadImageSetDefault(Context context, String url, final ImageView iv, @DrawableRes int resourceId) {
        if (context == null) {
            return;
        }
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if(((Activity)context).isDestroyed()){
            return;
        }
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(resourceId);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    //可以自己设置加载失败的时候显示的图片
    public static void loadImageSetError(Context context, String url, final ImageView iv, @DrawableRes int resourceId) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .error(resourceId);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    //该方法可以给任意View设置背景
    public static void loadImageBackground(Context context, String url, final View iv, @DrawableRes int resourceId) {
        if (context == null) {
            return;
        }
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if(((Activity)context).isDestroyed()){
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(resourceId);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        iv.setBackground(resource);
                    }
                });
    }

    //无默认加载图片的方法
    public static void loadImage(Context context, String url, final ImageView iv) {
        if (context == null) {
            return;
        }
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if(((Activity)context).isDestroyed()){
            return;
        }
        Glide.with(context)
                .load(url)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        iv.setImageDrawable(resource);
                    }
                });
    }

    public static void loadGif(Context context, String url, final ImageView iv) {
        if (context == null) {
            return;
        }
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if(((Activity)context).isDestroyed()){
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    public static void loadimageFirst(Context context, String url, final ImageView iv) {
        if (context == null) {
            return;
        }
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if(((Activity)context).isDestroyed()){
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH);
        Glide.with(context).load(url).apply(options).into(iv);
    }
}
