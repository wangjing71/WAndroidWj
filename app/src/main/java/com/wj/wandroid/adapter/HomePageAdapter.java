package com.wj.wandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wj.wandroid.R;


/**
 * author wangjing
 * Date 2019/3/1
 * Description
 */
public class HomePageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public HomePageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        viewHolder = new MineItemViewHolder(LayoutInflater.from(context).inflate(R.layout.main_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MineItemViewHolder mineItemViewHolder = (MineItemViewHolder) holder;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MineItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView childItem;

        public MineItemViewHolder(View view) {
            super(view);
        }
    }
}
