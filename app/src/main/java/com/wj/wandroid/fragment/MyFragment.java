package com.wj.wandroid.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
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
public class MyFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private SmartRefreshLayout refreshLayout;
    private Gson gson = new Gson();
    private List<ImageBean.DataBean> dataList = new ArrayList<>();
    private MyRecyclerAdapter myRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablayout,null,false);
        initView(view);
        initData();
        setEvent();
        return view;
    }


    private void initView(View root) {
        mRecyclerView = root.findViewById(R.id.recyclerView);
        refreshLayout = root.findViewById(R.id.refreshLayout);
    }

    private void initData() {
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecyclerView.setLayoutManager(manager);
        myRecyclerAdapter = new MyRecyclerAdapter(getContext());
        myRecyclerAdapter.setDataList(dataList);
        mRecyclerView.setAdapter(myRecyclerAdapter);
    }

    private void setEvent() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

                refreshLayout.finishRefresh();
            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {



                refreshLayout.finishLoadMore();
            }
        });
    }

    private void initHomeList() {
        HttpRequestUtils.get(Constant.SPLASH_IMAGE, new HttpRequestUtils.StringCallBack() {
            @Override
            public void onSuccess(String result) {
                ImageBean imageBean = gson.fromJson(result,ImageBean.class);
                List<ImageBean.DataBean> data = imageBean.getData();
                dataList.addAll(data);
                myRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail() {

            }
        });
    }
}
