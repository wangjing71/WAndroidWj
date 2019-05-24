package com.wj.wandroid.util;

import android.content.Context;
import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;


/**
 * author wangjing
 * Date 2018/11/20
 * Description
 */
public class HttpRequestUtils {

    public interface StringCallBack {
        void onSuccess(String result);

        void onFail();
    }

    public static void get(String path, final StringCallBack callback) {
        OkGo.<String>get(path)                            // 请求方式和请求url
                .cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.i("====出参",response.body());
                        callback.onSuccess(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        callback.onFail();
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
