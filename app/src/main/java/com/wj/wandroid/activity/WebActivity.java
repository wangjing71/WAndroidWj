package com.wj.wandroid.activity;

import android.webkit.WebView;
import android.widget.TextView;

import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseActivity;

/**
 * author wangjing
 * Date 2019/5/22
 * Description
 */
public class WebActivity extends BaseActivity {
    private TextView title;
    private WebView webView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        title = findViewById(R.id.title);
        webView = findViewById(R.id.webview);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {

    }
}
