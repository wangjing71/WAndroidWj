package com.wj.wandroid.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wj.wandroid.Constant;
import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.bean.ImageBean;
import com.wj.wandroid.util.HttpRequestUtils;

import java.util.Random;

/**
 * author wangjing
 * Date 2019/5/21
 * Description
 */
public class ImageAdActivity extends BaseActivity {
    private ImageView adImg;
    private TextView skip;
    private int time = 6;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            time--;
            if (time == 0) {
                startHomePage(false);
            }
            skip.setText("跳过 " + time);
            handler.sendEmptyMessageDelayed(0, 1000);
        }
    };

    @Override
    protected int setLayoutId() {
        return R.layout.activity_image_ad;
    }

    @Override
    protected void initView() {
        adImg = findViewById(R.id.ad_img);
        skip = findViewById(R.id.skip);
        skip.setText("跳过 " + time);
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    protected void initData() {
        HttpRequestUtils.get(Constant.SPLASH_IMAGE, new HttpRequestUtils.StringCallBack() {
            @Override
            public void onSuccess(String result) {
                ImageBean imageBean = gson.fromJson(result,ImageBean.class);
                int count = imageBean.getData().size();
                Random r=new Random();
                int i1=r.nextInt(count-1);    //生成[0,10]区间的整数
                String url = imageBean.getData().get(i1).getImage_url();
                Glide.with(ImageAdActivity.this).load(url).into(adImg);
            }

            @Override
            public void onFail() {

            }
        });
    }

    @Override
    protected void setEvent() {

    }

    private void startHomePage(boolean isClick) {
        handler.removeMessages(0);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


}
