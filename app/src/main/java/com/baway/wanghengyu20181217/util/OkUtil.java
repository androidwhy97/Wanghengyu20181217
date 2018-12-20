package com.baway.wanghengyu20181217.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 文件描述：ok工具类
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class OkUtil {

    public static OkHttpClient okHttpClient;

    //私有化构造
    private OkUtil() {
    }

    public static void init(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(3000, TimeUnit.MILLISECONDS);
        builder.writeTimeout(3000, TimeUnit.MILLISECONDS);
        builder.connectTimeout(3000, TimeUnit.MILLISECONDS);
        builder.addInterceptor(new OkLogInterceptor());//日志拦截器
        okHttpClient = builder.build();
    }
}
