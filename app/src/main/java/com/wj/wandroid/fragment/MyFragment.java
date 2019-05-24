package com.wj.wandroid.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wj.wandroid.Constant;
import com.wj.wandroid.R;
import com.wj.wandroid.activity.ImageAdActivity;
import com.wj.wandroid.adapter.MyRecyclerAdapter;
import com.wj.wandroid.bean.ImageBean;
import com.wj.wandroid.util.HttpRequestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author: smile .
 * date: On 2018/5/30
 */
public class MyFragment extends BaseLazyFragment {

    private RecyclerView mRecyclerView;
    private SmartRefreshLayout refreshLayout;
    private Gson gson = new Gson();
    private List<ImageBean.DataBean> dataList = new ArrayList<>();
    private MyRecyclerAdapter myRecyclerAdapter;
    private int pageIndex = 0;
    private String type ;
    private CircularProgressView circularProgressView;
    private StaggeredGridLayoutManager manager;

    @Override
    public int setContentViewId() {
        return R.layout.fragment_tablayout;
    }


    @Override
    public void initView(View root) {
        mRecyclerView = root.findViewById(R.id.recyclerView);
        refreshLayout = root.findViewById(R.id.refreshLayout);
        circularProgressView = root.findViewById(R.id.progress_view);

        refreshLayout.setPrimaryColorsId(R.color.red_primary, android.R.color.white);
    }

    @Override
    protected void initData() {
        if (getArguments() != null) {
            type =  getArguments().getString("type");
        }
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecyclerView.setLayoutManager(manager);
        myRecyclerAdapter = new MyRecyclerAdapter(getContext());
        myRecyclerAdapter.setDataList(dataList);
        ((DefaultItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        mRecyclerView.getItemAnimator().setChangeDuration(0);
        mRecyclerView.setAdapter(myRecyclerAdapter);
        initHomeList();
    }

    @Override
    public void setEvent() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageIndex = 0;
                dataList.clear();
                initHomeList();
                refreshLayout.finishRefresh();
            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                initHomeList();
                refreshLayout.finishLoadMore();
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                manager.invalidateSpanAssignments();//防止第一行到顶部有空白
            }
        });

    }

    private void initHomeList() {
        String url = Constant.SPLASH_IMAGE.replaceAll("%number",pageIndex+"").replaceAll("%type",type);
        HttpRequestUtils.get(url, new HttpRequestUtils.StringCallBack() {
            @Override
            public void onSuccess(String result) {
                circularProgressView.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                ImageBean imageBean = gson.fromJson(result,ImageBean.class);
                List<ImageBean.DataBean> data = imageBean.getData();
                for (int i = 0; i < data.size(); i++) {
                    ImageBean.DataBean bean = data.get(i);
                    String url = bean.getImage_url();
                    if(!TextUtils.isEmpty(url)){
                        dataList.add(bean);
                    }
                }
                myRecyclerAdapter.notifyDataSetChanged();
                pageIndex++;
            }

            @Override
            public void onFail() {

            }
        });
    }
}
