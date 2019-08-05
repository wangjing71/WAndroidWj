package com.wj.wandroid.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wj.wandroid.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author wangjing
 * Date 2019/3/6
 * Description
 */
public class FastEnterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public FastEnterAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        viewHolder = new FastEnterHolder(LayoutInflater.from(context).inflate(R.layout.fast_enter_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final FastEnterHolder addressKey = (FastEnterHolder) holder;
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class FastEnterHolder extends RecyclerView.ViewHolder {

        public FastEnterHolder(View view) {
            super(view);
        }
    }

    interface onItemclickListener{
        void itemClick(int position);
    }

    public SpannableString matcherSearchText(int color, String text, String keyword) {
        SpannableString ss = new SpannableString(text);
        Pattern pattern = Pattern.compile(keyword);
        Matcher matcher = pattern.matcher(ss);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            ss.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return ss;
    }
}
