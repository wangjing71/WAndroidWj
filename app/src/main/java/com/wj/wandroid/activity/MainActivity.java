package com.wj.wandroid.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.wj.wandroid.R;
import com.wj.wandroid.adapter.HomeViewPagerAdapter;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.fragment.HomePageFragment;
import com.wj.wandroid.util.GlideUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private HomeViewPagerAdapter homeViewPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    private LinearLayout tabMenu;
    private int[] defaultIconList =
            new int[]{R.mipmap.home_def, R.mipmap.activity_def, R.mipmap.message_def, R.mipmap.mine_def};
    private int[] focusIconList =
            new int[]{R.mipmap.home_foc, R.mipmap.activity_foc, R.mipmap.message_foc, R.mipmap.mine_foc};
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
        for (int i = 0; i < 4; i++) {
            View items = LayoutInflater.from(this).inflate(R.layout.tab_menu_item, null, false);
            ImageView focused_icon = items.findViewById(R.id.focused_icon);
            ImageView default_icon = items.findViewById(R.id.default_icon);
            Glide.with(this).load(defaultIconList[i]).into(focused_icon);
            Glide.with(this).load(focusIconList[i]).into(default_icon);
            tabMenu.addView(items);
        }
    }

    private void initFragment() {
    }


    @Override
    protected void setEvent() {

    }
}
