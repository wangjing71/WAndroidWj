package com.wj.wandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gyf.immersionbar.ImmersionBar;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wj.wandroid.R;


/**
 * Created by Administrator on 2018/1/4.
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected RxPermissions rxPermissions;
    private View barView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ImmersionBar.with(this).init();
        rxPermissions = new RxPermissions(this);
        barView = findViewById(R.id.barView);
        ImmersionBar.setStatusBarView(this, barView);
        initView();
        initData();
        setEvent();
    }

    protected abstract int setLayoutId();
    protected abstract void initView() ;
    protected abstract void initData() ;
    protected abstract void setEvent() ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}