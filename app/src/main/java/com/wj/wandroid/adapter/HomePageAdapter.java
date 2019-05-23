package com.wj.wandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wj.wandroid.R;
import com.wj.wandroid.activity.WebActivity;

import java.util.List;


/**
 * author wangjing
 * Date 2019/3/1
 * Description
 */
public class HomePageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HomeListBean.DataBean.DatasBean> datasBeanList;

    public void setDatasBeanList(List<HomeListBean.DataBean.DatasBean> datasBeanList) {
        this.datasBeanList = datasBeanList;
    }

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
        final HomeListBean.DataBean.DatasBean itemBean = datasBeanList.get(position);
        mineItemViewHolder.time.setText(itemBean.getNiceDate());
        mineItemViewHolder.author.setText(itemBean.getAuthor());
        mineItemViewHolder.title.setText(itemBean.getTitle());
        mineItemViewHolder.menu.setText(itemBean.getSuperChapterName());
        mineItemViewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("title",itemBean.getTitle());
                intent.putExtra("url",itemBean.getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(datasBeanList == null){
            return 0;
        }else{
            return datasBeanList.size();
        }
    }

    class MineItemViewHolder extends RecyclerView.ViewHolder {
        private TextView author;
        private TextView time;
        private TextView title;
        private TextView menu;
        private LinearLayout parent;

        public MineItemViewHolder(View view) {
            super(view);
            author = view.findViewById(R.id.auther);
            time = view.findViewById(R.id.time);
            title = view.findViewById(R.id.title);
            menu = view.findViewById(R.id.menu);
            parent = view.findViewById(R.id.parent);
        }
    }
}
