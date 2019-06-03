package com.wj.wandroid.activity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.bean.ImageBean;

import java.io.IOException;

/**
 * author wangjing
 * Date 2019/6/3
 * Description
 */
public class ImageDetailActivity extends BaseActivity {
    private TextView title;
    private ImageBean.DataBean item;
    private LinearLayout back;
    private ImageView iv;
    private Button save;
    private Button share;
    private Button wall;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_image_detail;
    }

    @Override
    protected void initView() {
        title = findViewById(R.id.title);
        back = findViewById(R.id.title_bar_back);
        iv = findViewById(R.id.image);
        save = findViewById(R.id.save);
        share = findViewById(R.id.share);
        wall = findViewById(R.id.wall);
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        item = (ImageBean.DataBean) intent.getSerializableExtra("item");
        if (!TextUtils.isEmpty(item.getDesc())) {
            title.setText(item.getDesc());
        }
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher);
        Glide.with(this).load(item.getImage_url()).apply(options).into(iv);
    }

    @Override
    protected void setEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = iv.getDrawable();
                try {
                    WallpaperManager.getInstance(ImageDetailActivity.this).setBitmap(drawable2Bitmap(drawable));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof NinePatchDrawable) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        } else {
            return null;
        }
    }
}
