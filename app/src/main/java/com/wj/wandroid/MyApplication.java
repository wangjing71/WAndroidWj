package com.wj.wandroid;

import android.app.Application;

import com.lzy.okgo.OkGo;

/**
 * author wangjing
 * Date 2018/11/29
 * Description
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initOKGo();

    }

    private void initOKGo() {
        OkGo.getInstance().init(this);
    }
}
