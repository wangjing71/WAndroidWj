package com.wj.wandroid.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
        initWebView(webView);
        webView.loadUrl("http://www.baidu.com");


    }

    @Override
    protected void setEvent() {

    }

    private void initWebView(WebView webView) {
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setBlockNetworkImage(false);
//        webSettings.setMediaPlaybackRequiresUserGesture(false);
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        webSettings.setSupportZoom(true);
//        webSettings.setAllowFileAccess(true);
//        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//
//        webSettings.setUseWideViewPort(true);
//        webSettings.setLoadWithOverviewMode(true);
//        String ua = webSettings.getUserAgentString();
//        webSettings.setDatabaseEnabled(true);
//        String dir = getApplicationContext()
//                .getDir("database", Context.MODE_PRIVATE).getPath();
//        webSettings.setGeolocationDatabasePath(dir);
//        webSettings.setGeolocationEnabled(true);



        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setUseWideViewPort(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setLoadWithOverviewMode(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setInitialScale(100);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress > 80) {

                }else{

                }
            }
        });
    }
}
