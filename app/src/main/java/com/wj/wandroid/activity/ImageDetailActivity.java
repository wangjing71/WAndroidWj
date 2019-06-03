package com.wj.wandroid.activity;

import android.content.Intent;
import android.widget.TextView;

import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;
import com.wj.wandroid.bean.ImageBean;

/**
 * author wangjing
 * Date 2019/6/3
 * Description
 */
public class ImageDetailActivity extends BaseActivity {
    private TextView title;
    private ImageBean.DataBean item;

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

        Intent intent = getIntent();
        item = (ImageBean.DataBean) intent.getSerializableExtra("item");

        title.setText(item.getDesc());
    }

    @Override
    protected void setEvent() {

    }
}
