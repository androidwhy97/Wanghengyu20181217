package com.baway.wanghengyu20181217.entity;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class InnerInResponseBean {
    private double bargainPrice;

    private String createtime;

    private String detailUrl;

    private String images;

    private int num;

    private int pid;

    private double price;

    private int pscid;

    private int selected;

    private int sellerid;

    private String subhead;

    private String title;

    public void setBargainPrice(double bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public double getBargainPrice() {
        return this.bargainPrice;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImages() {
        return this.images;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return this.pid;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPscid(int pscid) {
        this.pscid = pscid;
    }

    public int getPscid() {
        return this.pscid;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected==1;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    public int getSellerid() {
        return this.sellerid;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getSubhead() {
        return this.subhead;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
