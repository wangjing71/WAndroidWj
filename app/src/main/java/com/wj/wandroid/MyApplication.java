package com.wj.wandroid;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.tencent.bugly.crashreport.CrashReport;

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

        initBugly();

    }

    private void initBugly() {
        CrashReport.initCrashReport(getApplicationContext(), "bf2285b85d", false);
    }

    private void initOKGo() {
        OkGo.getInstance().init(this);
    }
}
