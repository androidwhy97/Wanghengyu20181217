package com.baway.wanghengyu20181217;

import com.baway.wanghengyu20181217.entity.RootResponseBean;
import com.baway.wanghengyu20181217.service.GoodsService;
import com.baway.wanghengyu20181217.util.RetrofitApi;

import io.reactivex.Observable;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class ShopCartModel {
    public Observable<RootResponseBean> getList(String uid){
        GoodsService goodsService = RetrofitApi.getInstance().createApi(GoodsService.class);
        return goodsService.getShopCart(uid);
    }
}
