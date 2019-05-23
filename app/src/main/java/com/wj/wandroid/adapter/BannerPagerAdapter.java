package com.wj.wandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wj.wandroid.R;

import java.util.List;

/**
 * author wangjing
 * Date 2018/12/20
 * Description
 */
public class BannerPagerAdapter extends PagerAdapter {

    private List<BannerBean.DataBean> urlDatas;
    private Context context;
    private onBannerItemClick onBannerItemClick;

    public BannerPagerAdapter(Context context, List<BannerBean.DataBean> urlDatas) {
        this.context = context;
        this.urlDatas = urlDatas;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View item = LayoutInflater.from(context).inflate(R.layout.home_banner_item, null, false);
        ImageView iv = item.findViewById(R.id.item_mz_banner_adapter_iv);
        Glide.with(context).load(urlDatas.get(position % urlDatas.size()).getImagePath()).into(iv);
        container.addView(item);
        return item;
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

    public interface onBannerItemClick {
        void itemClick(int position);
    }

    //设置外部接口回调
    public void setOnBannerItemClick(onBannerItemClick onBannerItemClick) {
        this.onBannerItemClick = onBannerItemClick;
    }
}
