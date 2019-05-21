package com.wj.wandroid.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;

import io.reactivex.functions.Consumer;


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

    }

    @Override
    protected void initData() {
        rxPermissions.request(Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
                        handler.sendEmptyMessageDelayed(0,2000);
                    }
                });
    }

    @Override
    protected void setEvent() {

    }
}
