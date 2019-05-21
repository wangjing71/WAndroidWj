package com.wj.wandroid.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wj.wandroid.R;
import com.wj.wandroid.adapter.HeaderAndFooterWrapper;
import com.wj.wandroid.adapter.HomePageAdapter;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.util.HttpRequestUtils;


public class MainActivity extends BaseActivity {

    private SmartRefreshLayout refreshLayout;
    private RecyclerView mRecyclerView;

    private HomePageAdapter homePageAdapter;
    private HeaderAndFooterWrapper wrapper;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mRecyclerView = findViewById(R.id.recyclerView_market);
        refreshLayout = findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setItemAnimator(null);

        homePageAdapter = new HomePageAdapter(this);
        homePageAdapter.setHasStableIds(true);

        wrapper = new HeaderAndFooterWrapper(homePageAdapter);
        mRecyclerView.setAdapter(wrapper);
        refreshLayout.setEnableLoadMore(false);

        initBanner();
    }

    private void initBanner() {
        View banner = LayoutInflater.from(this).inflate(R.layout.home_banner_layout,null,false);
        wrapper.addHeaderView(banner);
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
