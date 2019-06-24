package com.wj.wandroid.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.wj.wandroid.R;
import com.wj.wandroid.adapter.HomeViewPagerAdapter;
import com.wj.wandroid.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private HomeViewPagerAdapter homeViewPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();

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
        for (int i = 0; i < 4; i++) {

        }
        homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), fragmentList);
    }

    @Override
    protected void setEvent() {

    }
}
