package com.baway.wanghengyu20181217;

import com.baway.wanghengyu20181217.entity.RootResponseBean; /**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public interface ShopCartView {
    void success(RootResponseBean rootResponseBean);

    void fail(String error);
}
