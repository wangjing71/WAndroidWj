package com.wj.wandroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tablayout,null,false);
        initView(view);
        initData();
        setEvent();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new MyRecyclerAdapter(getContext()));
        return view;
    }


    private void initView(View root) {

    }

    private void initData() {

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
