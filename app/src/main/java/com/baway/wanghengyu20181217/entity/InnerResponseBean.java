package com.baway.wanghengyu20181217.entity;

import java.util.List;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class InnerResponseBean {
    private List<InnerInResponseBean> list;
    private boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    private String sellerName;

    private String sellerid;

    public void setList(List<InnerInResponseBean> list) {
        this.list = list;
    }

    public List<InnerInResponseBean> getList() {
        return this.list;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerName() {
        return this.sellerName;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getSellerid() {
        return this.sellerid;
    }
}
