package com.wj.wandroid.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wj.wandroid.R;
import com.wj.wandroid.adapter.ActlistAdapter;
import com.wj.wandroid.adapter.FastEnterAdapter;
import com.wj.wandroid.base.BaseLazyFragment;
import com.wj.wandroid.view.ViewPagerScroller;

import java.util.ArrayList;

/**
 * author wangjing
 * Date 2019/6/24
 * Description
 */
public class HomePageFragment1 extends BaseLazyFragment {
    @Override
    public int setContentViewId() {
        return R.layout.fragment_home1;
    }

    @Override
    public void initView(View root) {

    }

    @Override
    protected void initData() {

    }
}
