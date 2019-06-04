package com.wj.wandroid.activity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Environment;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.dingmouren.layoutmanagergroup.viewpager.ViewPagerLayoutManager;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okserver.OkDownload;
import com.lzy.okserver.download.DownloadListener;
import com.lzy.okserver.download.DownloadTask;
import com.wj.wandroid.R;
import com.wj.wandroid.adapter.MyRecyclerAdapter;
import com.wj.wandroid.adapter.MyRecyclerAdapterDetail;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.bean.ImageBean;
import com.wj.wandroid.listener.SimpleFileDownloadListener;
import com.wj.wandroid.util.GlideBlurformation;

import java.io.File;
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
    private List<ImageBean.DataBean> dataList;
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
        position = intent.getIntExtra("position", 0);

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
                saveImage();
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
                if (newState == 0) {
                    ViewPagerLayoutManager manager = (ViewPagerLayoutManager) recyclerView.getLayoutManager();
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    if (lastVisibleItem >= 0) {
                        position = lastVisibleItem;
                        RequestOptions options = new RequestOptions()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .transform(new GlideBlurformation(ImageDetailActivity.this));
                        Glide.with(ImageDetailActivity.this).load(dataList.get(position).getImage_url()).apply(options).into(background);
                    }
                }
            }
        });

    }

    private void saveImage() {
//        FileDownloader.setup(this);
//        FileDownloader.getImpl().create(dataList.get(position).getDownload_url())
//                .setPath(Environment.getExternalStorageDirectory().getPath(),false)
//                .setListener(new SimpleFileDownloadListener(){
//                    @Override
//                    protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
//                        Toast.makeText(ImageDetailActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
//                    }
//
//                    @Override
//                    protected void completed(BaseDownloadTask task) {
//                        Toast.makeText(ImageDetailActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
//                    }
//                }).start();

        String url = dataList.get(position).getDownload_url();
        GetRequest<File> request = OkGo.get(url);
        DownloadTask task = OkDownload.request(url, request).save().register(new DownloadListener(this) {
            @Override
            public void onStart(Progress progress) {
                Toast.makeText(ImageDetailActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgress(Progress progress) {
            }

            @Override
            public void onError(Progress progress) {
                Toast.makeText(ImageDetailActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish(File file, Progress progress) {
                Toast.makeText(ImageDetailActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRemove(Progress progress) {

            }
        });
        task.folder(Environment.getExternalStorageDirectory().getPath()+File.separator+"imageSave");
        task.start();

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
