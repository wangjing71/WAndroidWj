package com.wj.wandroid.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;

import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;


/**
 * author wangjing
 * Date 2019/5/21
 * Description
 */
public class SplashActivity extends BaseActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(SplashActivity.this,ImageAdActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        handler.sendEmptyMessageDelayed(0,2000);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initData() {
    }

    @Override
    protected void setEvent() {

    }
}
