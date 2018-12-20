package com.baway.wanghengyu20181217.util;

import android.util.Log;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class OkLogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String method = request.method();
        HttpUrl url = request.url();

        Log.d("本次请求", "url: " + url.toString() + "请求方式: " + method);

        Headers headers = request.headers();
        Set<String> names = headers.names();
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String value = headers.get(next);
            Log.d("本次请求", next + ":" + value);
        }
        return chain.proceed(request);
    }
}
