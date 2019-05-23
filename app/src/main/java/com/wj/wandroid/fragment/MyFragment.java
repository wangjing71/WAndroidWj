package com.wj.wandroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wj.wandroid.R;
import com.wj.wandroid.adapter.MyRecyclerAdapter;

/**
 * author: smile .
 * date: On 2018/5/30
 */
public class MyFragment extends Fragment {

    private RecyclerView mRecyclerView;

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
    }

    private void initData() {
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));//设置RecyclerView布局管理器为2列垂直排布
        mRecyclerView.setAdapter(new MyRecyclerAdapter(getContext()));
    }

    private void setEvent() {

    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new MyRecyclerAdapter(getContext()));
    }
}
