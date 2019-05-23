package com.wj.wandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.wj.wandroid.R;
import com.wj.wandroid.adapter.HomeFragmentPager;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private Toolbar mToolbar;
    private ActionBar mActionbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> titles = new ArrayList<String>();

    private String[] titleList = {"小清新", "诱惑", "唯美", "日韩美女", "长腿", "性感", "气质"};

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    protected void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    protected void initData() {
        titles.add("小清新");
        titles.add("诱惑");
        titles.add("唯美");
        titles.add("日韩美女");
        titles.add("长腿");
        titles.add("性感");
        titles.add("气质");



        setSupportActionBar(mToolbar);
        mActionbar = getSupportActionBar();
        mActionbar.setTitle("谦行");
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new MyFragment());
        }
        HomeFragmentPager fragmentPager = new HomeFragmentPager(getSupportFragmentManager(), fragments, titles);
        // 给ViewPager 设置适配器
        mViewPager.setAdapter(fragmentPager);
        //  将TabLayout 和 ViewPager 关联起来
        mTabLayout.setupWithViewPager(mViewPager);
    }

    protected void setEvent() {

    }
}
