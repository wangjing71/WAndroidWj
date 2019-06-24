package com.wj.wandroid.activity;

import android.support.v4.view.ViewPager;

import com.wj.wandroid.R;
import com.wj.wandroid.adapter.HomeViewPagerAdapter;
import com.wj.wandroid.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private HomeViewPagerAdapter homeViewPagerAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mViewPager = findViewById(R.id.vp_main);
    }

    @Override
    protected void initData() {
        homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(),,);
    }

    @Override
    protected void setEvent() {

    }
}
