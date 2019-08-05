package com.wj.wandroid.fragment;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseLazyFragment;

import q.rorbin.badgeview.QBadgeView;

/**
 * author wangjing
 * Date 2019/6/24
 * Description
 */
public class HomePageFragment extends BaseLazyFragment {
    private ViewPager banner;


    //需要无参构造方法
    public HomePageFragment() {
    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View root) {
    }

    @Override
    protected void initData() {
    }


    @Override
    public void setEvent() {
    }
}
