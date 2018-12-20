package com.baway.wanghengyu20181217.entity;

import java.util.List;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class RootResponseBean {
    private String msg;

    private String code;

    private List<InnerResponseBean> data ;

    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setData(List<InnerResponseBean> data){
        this.data = data;
    }
    public List<InnerResponseBean> getData(){
        return this.data;
    }
}
