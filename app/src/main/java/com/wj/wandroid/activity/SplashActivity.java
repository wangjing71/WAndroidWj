package com.wj.wandroid.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;

import java.util.function.Consumer;

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
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
                    }
                });
    }

    @Override
    protected void setEvent() {

    }
}
