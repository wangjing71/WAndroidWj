package com.wj.wandroid.util;

import android.content.Context;
import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.wj.wandroid.Constant;


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

    public static void get(Context context, String path, final StringCallBack callback) {
        OkGo.<String>get(Constant.HOST_URL + path)                            // 请求方式和请求url
                .cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.i("====", response.body());
                        callback.onSuccess(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        callback.onFail();
                    }
                });
    }
}
