package com.baway.wanghengyu20181217.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 文件描述：retrofit工具类
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class RetrofitApi {
    private static RetrofitApi instance;
    private Retrofit mRetrofit;

    //私有化构造
    private RetrofitApi() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(UrlHolder.BASEURL);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.client(OkUtil.okHttpClient);
        mRetrofit = builder.build();
    }

    //单例模式
    public static RetrofitApi getInstance() {
        if (instance == null) {
            instance = new RetrofitApi();
        }
        return instance;
    }

    public <T> T createApi(Class<T> cls) {
        T t = mRetrofit.create(cls);
        return t;
    }
}
