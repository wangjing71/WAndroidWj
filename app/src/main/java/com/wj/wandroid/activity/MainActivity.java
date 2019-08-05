package com.wj.wandroid.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wj.wandroid.R;
import com.wj.wandroid.adapter.HomeViewPagerAdapter;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.fragment.HomePageFragment;
import com.wj.wandroid.fragment.HomePageFragment1;
import com.wj.wandroid.fragment.HomePageFragment2;
import com.wj.wandroid.fragment.HomePageFragment3;
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
    private String[] titleList =
            new String[]{"首页","活动","消息","我的"};
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

        fragmentList.add(new HomePageFragment());
        fragmentList.add(new HomePageFragment1());
        fragmentList.add(new HomePageFragment2());
        fragmentList.add(new HomePageFragment3());


        homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(homeViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);
    }

    private void initTabMenu() {
        for (int i = 0; i < 4; i++) {
            View items = LayoutInflater.from(this).inflate(R.layout.tab_menu_item, null, false);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1;
            items.setLayoutParams(params);
            ImageView focused_icon = items.findViewById(R.id.focused_icon);
            ImageView default_icon = items.findViewById(R.id.default_icon);
            TextView focused_title = items.findViewById(R.id.focused_title);
            TextView default_title = items.findViewById(R.id.default_title);
            focused_title.setText(titleList[i]);
            default_title.setText(titleList[i]);
            Glide.with(this).load(focusIconList[i]).into(focused_icon);
            Glide.with(this).load(defaultIconList[i]).into(default_icon);
            tabMenu.addView(items);

            final int finalI = i;
            items.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initBottonSelectIndex(finalI);
                }
            });
            initBottonSelectIndex(0);
        }
    }

    private void initFragment() {
    }


    @Override
    protected void setEvent() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                initBottonSelectIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initBottonSelectIndex(int index) {
        mViewPager.setCurrentItem(index, false);
        int count = tabMenu.getChildCount();
        for (int i = 0; i < count; i++) {
            View itemsParents = tabMenu.getChildAt(i);
            if(i == index){
                itemsParents.findViewById(R.id.focused_parent).setVisibility(View.VISIBLE);
                itemsParents.findViewById(R.id.default_parent).setVisibility(View.GONE);
            }else{
                itemsParents.findViewById(R.id.focused_parent).setVisibility(View.GONE);
                itemsParents.findViewById(R.id.default_parent).setVisibility(View.VISIBLE);
            }
        }
    }
}
