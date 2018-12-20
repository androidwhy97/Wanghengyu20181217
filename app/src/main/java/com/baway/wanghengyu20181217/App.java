package com.baway.wanghengyu20181217;

import android.app.Application;

import com.baway.wanghengyu20181217.util.OkUtil;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ok
        OkUtil.init();
        //初始化fresco,配置缓存路径
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this)
                        .setBaseDirectoryPath(new File(getCacheDir().getAbsolutePath()))
                        .build())
                .build();
        Fresco.initialize(this, config);
    }
}
