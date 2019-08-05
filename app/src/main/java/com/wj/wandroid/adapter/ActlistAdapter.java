package com.wj.wandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wj.wandroid.R;


/**
 * author wangjing
 * Date 2019/3/6
 * Description
 */
public class ActlistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public ActlistAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        viewHolder = new FastEnterHolder(LayoutInflater.from(context).inflate(R.layout.act_list_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final FastEnterHolder addressKey = (FastEnterHolder) holder;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class FastEnterHolder extends RecyclerView.ViewHolder {

        public FastEnterHolder(View view) {
            super(view);
        }
    }

    interface onItemclickListener{
        void itemClick(int position);
    }

}
