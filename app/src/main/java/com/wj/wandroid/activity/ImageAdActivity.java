package com.wj.wandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.wj.wandroid.R;

/**
 * author wangjing
 * Date 2019/5/21
 * Description
 */
public class ImageAdActivity extends Activity {
    private ImageView adImg;
    private TextView skip;
    private int time = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ImmersionBar.with(this).init();
        initView();
        initData();
        setEvent();
    }

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

    protected int setLayoutId() {
        return R.layout.activity_image_ad;
    }

    protected void initView() {
        adImg = findViewById(R.id.ad_img);
        skip = findViewById(R.id.skip);
        skip.setText("跳过 " + time);
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    protected void initData() {
    }

    protected void setEvent() {

    }

    private void startHomePage(boolean isClick) {
        handler.removeMessages(0);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


}
