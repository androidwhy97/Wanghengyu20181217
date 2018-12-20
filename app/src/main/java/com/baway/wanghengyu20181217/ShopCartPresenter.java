package com.baway.wanghengyu20181217;

import com.baway.wanghengyu20181217.entity.RootResponseBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class ShopCartPresenter {
    private final ShopCartModel shopCartModel;
    private ShopCartView shopCartView;

    public ShopCartPresenter(ShopCartView shopCartView) {
        this.shopCartView = shopCartView;
        shopCartModel = new ShopCartModel();
    }

    public void getShopcart(String uid) {
        Observable<RootResponseBean> shopCartModelList = shopCartModel.getList(uid);
        shopCartModelList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RootResponseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RootResponseBean rootResponseBean) {
                        if (rootResponseBean != null) {
                            shopCartView.success(rootResponseBean);
                        } else {
                            shopCartView.fail("响应对象为空");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        shopCartView.fail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void onDestory(){
        if (shopCartView!=null){
            shopCartView=null;
        }
    }
}
