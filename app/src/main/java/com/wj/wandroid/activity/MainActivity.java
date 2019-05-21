package com.wj.wandroid.activity;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.util.HttpRequestUtils;


public class MainActivity extends BaseActivity {

    private SmartRefreshLayout refreshLayout;
    private RecyclerView mRecyclerView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
    }

    private void doSomeThing() {
        HttpRequestUtils.get("banner/json", new HttpRequestUtils.StringCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.i("====",result);
            }

            @Override
            public void onFail() {

            }
        });
    }
}
