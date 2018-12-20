package com.baway.wanghengyu20181217.util;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class FrescoUtil {
    //基础展示图片
    public static void setBasePic(String url, SimpleDraweeView draweeView){
        Uri parse = Uri.parse(url);
        draweeView.setImageURI(parse);
    }
}
