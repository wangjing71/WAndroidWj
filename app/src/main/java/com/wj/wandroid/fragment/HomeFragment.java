package com.wj.wandroid.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.wj.wandroid.R;
import com.wj.wandroid.adapter.FastEnterAdapter;
import com.wj.wandroid.base.BaseLazyFragment;
import com.wj.wandroid.base.FloorItemBean;
import com.wj.wandroid.view.ViewPagerScroller;

import java.util.ArrayList;

/**
 * author wangjing
 * Date 2019/6/24
 * Description
 */
public class HomeFragment extends BaseLazyFragment {
    private ViewPager banner;
    private ArrayList<View> viewList = new ArrayList<>();
    private BannerAdapter bannerAdapter;
    private int bannerIndex = 0;

    private RecyclerView fastEnterRecyclerView;
    private FastEnterAdapter fastEnterAdapter;
    private ArrayList<FloorItemBean> fastListData = new ArrayList<>();


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            bannerIndex++;
            banner.setCurrentItem(bannerIndex);
            handler.removeMessages(0);
            handler.sendEmptyMessageDelayed(0,5000);
        }
    };

    //需要无参构造方法
    public HomeFragment() {
    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View root) {
        banner = root.findViewById(R.id.id_banner);
        fastEnterRecyclerView = root.findViewById(R.id.fastEnter);
    }

    @Override
    protected void initData() {
        initBanner();

        initFastEnter();
    }


    private void initFastEnter() {
        fastListData.add(new FloorItemBean("自驾游",R.mipmap.fast_1));
        fastListData.add(new FloorItemBean("狼人杀",R.mipmap.fast_2));
        fastListData.add(new FloorItemBean("运动",R.mipmap.fast_3));
        fastListData.add(new FloorItemBean("KTV",R.mipmap.fast_4));
        fastListData.add(new FloorItemBean("徒步",R.mipmap.fast_5));
        fastListData.add(new FloorItemBean("附近",R.mipmap.fast_6));
        fastListData.add(new FloorItemBean("周末",R.mipmap.fast_7));
        fastListData.add(new FloorItemBean("优惠券",R.mipmap.fast_8));


        fastEnterRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                fastEnterAdapter = new FastEnterAdapter(getContext());
                fastEnterAdapter.setParentHeight(fastEnterRecyclerView.getHeight());
                fastEnterAdapter.setFastListData(fastListData);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
                fastEnterRecyclerView.setLayoutManager(gridLayoutManager);
                fastEnterRecyclerView.setAdapter(fastEnterAdapter);
            }
        });
    }

    private void initBanner() {
        ViewPagerScroller scroller = new ViewPagerScroller(getContext());
        scroller.setScrollDuration(1500);
        scroller.initViewPagerScroll(banner);
        bannerIndex = viewList.size()*10;
        banner.setCurrentItem(bannerIndex);
        bannerAdapter = new BannerAdapter();
        banner.setAdapter(bannerAdapter);
        handler.sendEmptyMessageDelayed(0,5000);
    }

    @Override
    public void setEvent() {
        banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                bannerIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == 1) {
                    handler.removeMessages(0);
                } else if (state == 2) {
                    handler.sendEmptyMessageDelayed(0, 5000);
                }
            }
        });
    }

    class BannerAdapter extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            View page1 = LayoutInflater.from(getContext()).inflate(R.layout.home_banner_item,null,false);
            container.addView(page1);
            return page1;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
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
