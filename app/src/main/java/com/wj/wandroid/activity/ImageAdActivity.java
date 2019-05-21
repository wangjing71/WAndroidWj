package com.wj.wandroid.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;

/**
 * author wangjing
 * Date 2019/5/21
 * Description
 */
public class ImageAdActivity extends BaseActivity {
    private ImageView adImg;
    private TextView skip;
    private int time = 3;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            time--;
            if (time == 0) {
                startHomePage(false);
            }
            skip.setText("跳过 " + time);
            handler.sendEmptyMessageDelayed(0, 1000);
        }
    };

    @Override
    protected int setLayoutId() {
        return R.layout.activity_image_ad;
    }

    @Override
    protected void initView() {
        adImg = findViewById(R.id.ad_img);
        skip = findViewById(R.id.skip);
        skip.setText("跳过 " + time);
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    protected void initData() {
        doGet();
    }

    @Override
    protected void setEvent() {

    }

    private void startHomePage(boolean isClick) {
        handler.removeMessages(0);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


    private void doGet() {
        OkGo.<String>get("http://www.baidu.com")                            // 请求方式和请求url
                .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                .cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.i("====",response.body());
                    }
                });
    }

    private void doPost() {
        OkGo.<String>post("http://www.baidu.com")
                .tag(this)
                .cacheKey("cachePostKey")
                .cacheMode(CacheMode.DEFAULT)
                .params("param2", "paramValue2")
                .params("param3", "paramValue3")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.i("====",response.body());

                    }
                });
    }
}
