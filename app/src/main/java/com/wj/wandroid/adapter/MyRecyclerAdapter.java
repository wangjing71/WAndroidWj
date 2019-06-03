package com.wj.wandroid.adapter;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.kogitune.activity_transition.ActivityTransitionLauncher;
import com.wj.wandroid.R;
import com.wj.wandroid.activity.ImageDetailActivity;
import com.wj.wandroid.bean.ImageBean;

import java.io.IOException;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ImageBean.DataBean item = dataList.get(position);
        final String url = item.getImage_url();

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher);
        Glide.with(mContext).load(url).apply(options).into(holder.iv);
        holder.iv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewGroup.LayoutParams params = holder.iv.getLayoutParams();
                params.height = holder.iv.getWidth() * item.getImage_height() /item.getImage_width();
                params.width = holder.iv.getWidth();
                holder.iv.setLayoutParams(params);
            }
        });
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Drawable drawable = holder.iv.getDrawable();
//                try {
//                    WallpaperManager.getInstance(mContext).setBitmap(drawable2Bitmap(drawable));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }


                Intent intent = new Intent(mContext, ImageDetailActivity.class);
                intent.putExtra("item",item);
                ActivityTransitionLauncher.with((Activity) mContext).from(v).launch(intent);
            }
        });

        holder.iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, url, Toast.LENGTH_SHORT).show();


                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        if(dataList==null){
            return 0;
        }else{
            return dataList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }

    public Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof NinePatchDrawable) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        } else {
            return null;
        }
    }
}
