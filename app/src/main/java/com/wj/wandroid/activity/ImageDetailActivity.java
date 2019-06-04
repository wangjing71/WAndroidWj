package com.wj.wandroid.activity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.dingmouren.layoutmanagergroup.viewpager.ViewPagerLayoutManager;
import com.wj.wandroid.R;
import com.wj.wandroid.adapter.MyRecyclerAdapter;
import com.wj.wandroid.adapter.MyRecyclerAdapterDetail;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.bean.ImageBean;
import com.wj.wandroid.util.GlideBlurformation;

import java.util.List;

/**
 * author wangjing
 * Date 2019/6/3
 * Description
 */
public class ImageDetailActivity extends BaseActivity {
    private TextView title;
    private ImageBean.DataBean item;
    private LinearLayout back;
    private Button save;
    private Button share;
    private Button wall;
    private RecyclerView recyclerView;
    private List<ImageBean.DataBean> dataList ;
    private MyRecyclerAdapterDetail myRecyclerAdapter;
    private int position;
    private ImageView background;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_image_detail;
    }

    @Override
    protected void initView() {
        title = findViewById(R.id.title);
        back = findViewById(R.id.title_bar_back);
        save = findViewById(R.id.save);
        share = findViewById(R.id.share);
        wall = findViewById(R.id.wall);
        recyclerView = findViewById(R.id.mRecyclerView);
        background = findViewById(R.id.background);
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        item = (ImageBean.DataBean) intent.getSerializableExtra("item");
        dataList = (List<ImageBean.DataBean>) intent.getSerializableExtra("datas");
        position = intent.getIntExtra("position",0);

        if (!TextUtils.isEmpty(item.getDesc())) {
            title.setText(item.getDesc());
        }

        ViewPagerLayoutManager viewPagerLayoutManager = new ViewPagerLayoutManager(this, OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(viewPagerLayoutManager);
        myRecyclerAdapter = new MyRecyclerAdapterDetail(this);
        myRecyclerAdapter.setDataList(dataList);
        recyclerView.setAdapter(myRecyclerAdapter);
        viewPagerLayoutManager.scrollToPosition(position);
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideBlurformation(this));

        Glide.with(this).load(dataList.get(position).getImage_url()).apply(options).into(background);

    }

    @Override
    protected void setEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        wall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Drawable drawable = iv.getDrawable();
//                try {
//                    WallpaperManager.getInstance(ImageDetailActivity.this).setBitmap(drawable2Bitmap(drawable));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                Log.i("====",newState+"");
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                Log.i("====dx",dx+"");
//                Log.i("====dy",dy+"");
            }
        });

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
