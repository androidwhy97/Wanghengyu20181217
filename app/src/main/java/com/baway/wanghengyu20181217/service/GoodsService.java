package com.baway.wanghengyu20181217.service;

import com.baway.wanghengyu20181217.entity.RootResponseBean;
import com.baway.wanghengyu20181217.util.UrlHolder;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public interface GoodsService {
    @GET(UrlHolder.GOODSLIST_URL)
    Observable<RootResponseBean> getShopCart(@Query("uid") String uid);

}
