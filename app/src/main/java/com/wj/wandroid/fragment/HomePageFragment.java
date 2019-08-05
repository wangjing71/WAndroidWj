package com.wj.wandroid.fragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseLazyFragment;

import java.util.ArrayList;

import q.rorbin.badgeview.QBadgeView;

/**
 * author wangjing
 * Date 2019/6/24
 * Description
 */
public class HomePageFragment extends BaseLazyFragment {
    private ViewPager banner;
    private ArrayList<View> viewList = new ArrayList<>();
    private BannerAdapter bannerAdapter;

    //需要无参构造方法
    public HomePageFragment() {
    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View root) {
        banner = root.findViewById(R.id.id_banner);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 4; i++) {
            View page1 = LayoutInflater.from(getContext()).inflate(R.layout.home_banner_item,null,false);
            viewList.add(page1);
        }
        bannerAdapter = new BannerAdapter();
        banner.setAdapter(bannerAdapter);
    }

    @Override
    public void setEvent() {
    }

    class BannerAdapter extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            View item = viewList.get(position);
            container.addView(item);
            return item;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
