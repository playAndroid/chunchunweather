package com.groundhao.www.chunchunweather.net;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by haokun on 2017/2/26.
 */

public class HttpUtils {
    public static void sendOkHttpRequest(String url, Callback callback) {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        httpClient.newCall(request).enqueue(callback);

    }
}
