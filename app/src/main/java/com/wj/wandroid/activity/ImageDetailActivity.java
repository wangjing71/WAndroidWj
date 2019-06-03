package com.wj.wandroid.activity;

import android.widget.TextView;

import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;

/**
 * author wangjing
 * Date 2019/6/3
 * Description
 */
public class ImageDetailActivity extends BaseActivity {
    private TextView title;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_image_detail;
    }

    @Override
    protected void initView() {
        title = findViewById(R.id.title);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {

    }
}
