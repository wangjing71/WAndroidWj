package com.wj.wandroid.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gyf.immersionbar.ImmersionBar;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wj.wandroid.R;
import com.wj.wandroid.adapter.HomeFragmentPager;
import com.wj.wandroid.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ActionBar mActionbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> titles = new ArrayList<String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ImmersionBar.with(this).barColor(R.color.red_primary).init();
        ImmersionBar.with(this).init();
        initView();
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request( Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
                    }
                });
        initData();
        setEvent();
    }

    protected void initView() {
        ImmersionBar.setStatusBarView(this, findViewById(R.id.barView));
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    protected void initData() {
        titles.add("嫩萝莉");
        titles.add("长腿");
        titles.add("丝袜");
        titles.add("小清新");
        titles.add("诱惑");
        titles.add("唯美");
        titles.add("长发");
        titles.add("泳装");
        titles.add("美腿");
        titles.add("真人美女秀场");
        titles.add("性感");
        titles.add("气质");
        titles.add("可爱");
        titles.add("素颜");
        titles.add("非主流");
        titles.add("车模");
        titles.add("cosplay");
        titles.add("写真");

        setSupportActionBar(mToolbar);
        mActionbar = getSupportActionBar();
        mActionbar.setTitle("享受美好生活");
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < titles.size(); i++) {
            MyFragment myFragment = new MyFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putString("type", titles.get(i));
            myFragment.setArguments(bundle1);
            fragments.add(myFragment);
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
