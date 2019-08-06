package com.wj.wandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wj.wandroid.R;
import com.wj.wandroid.base.FloorItemBean;

import java.util.ArrayList;


/**
 * author wangjing
 * Date 2019/3/6
 * Description
 */
public class FastEnterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private int parentHeight;
    private ArrayList<FloorItemBean> fastListData;

    public void setFastListData(ArrayList<FloorItemBean> fastListData) {
        this.fastListData = fastListData;
    }

    public void setParentHeight(int parentHeight) {
        this.parentHeight = parentHeight;
    }

    public FastEnterAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.fast_enter_item, parent, false);
        view.getLayoutParams().height = parentHeight/2;
        viewHolder = new FastEnterHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final FastEnterHolder addressKey = (FastEnterHolder) holder;
    }

    @Override
    public int getItemCount() {
        if(fastListData==null){
            return 0;
        }else{
            return fastListData.size();
        }
    }

    class FastEnterHolder extends RecyclerView.ViewHolder {
        ImageView iv_icon;
        TextView tv_title;
        LinearLayout parent;

        public FastEnterHolder(View view) {
            super(view);
            iv_icon = view.findViewById(R.id.iv_icon);
            tv_title = view.findViewById(R.id.tv_title);
            parent = view.findViewById(R.id.parent);
        }
    }
}
