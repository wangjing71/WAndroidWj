package com.wj.wandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wj.wandroid.R;
import com.wj.wandroid.bean.ImageBean;

import java.util.List;

/**
 * author: smile .
 * date: On 2018/5/30
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    Context mContext;
    private List<ImageBean.DataBean> dataList;

    public void setDataList(List<ImageBean.DataBean> dataList) {
        this.dataList = dataList;
    }

    public MyRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.mllAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "总会有一个人让你想拼了命的努力变好！", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 200;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
