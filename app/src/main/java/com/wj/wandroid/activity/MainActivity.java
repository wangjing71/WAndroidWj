package com.wj.wandroid.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.wj.wandroid.R;
import com.wj.wandroid.adapter.HomeViewPagerAdapter;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.fragment.HomePageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private HomeViewPagerAdapter homeViewPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    private LinearLayout tabMenu;
    private int[] defaultIconList =
            new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] focusIconList =
            new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mViewPager = findViewById(R.id.vp_main);
        tabMenu = findViewById(R.id.tab_menu);
    }

    @Override
    protected void initData() {
        initTabMenu();
        initFragment();

        for (int i = 0; i < 4; i++) {
            fragmentList.add(new HomePageFragment());
        }
        homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(homeViewPagerAdapter);
    }

    private void initTabMenu() {
        View items = LayoutInflater.from(this).inflate(R.layout.tab_menu_item, null, false);
        for (int i = 0; i < 4; i++) {

        }
    }

    private void initFragment() {
    }


    @Override
    protected void setEvent() {

    }
}
