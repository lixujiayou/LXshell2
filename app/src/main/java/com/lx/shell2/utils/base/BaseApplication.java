package com.lx.shell2.utils.base;

import android.app.Application;

import com.lx.shell2.BuildConfig;
import com.lx.shell2.utils.tools.TimberUtil;

import timber.log.Timber;

/**
 * @auther lixu
 * Created by lixu on 2018/8/18.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        initTimber();
    }


    /**
     * Timer初始化
     */
    private void initTimber(){
        //设置log自动在apk为debug版本时打开，在release版本时关闭
        TimberUtil.setLogAuto();
        //也可以设置log一直开
        //TimberUtil.setLogDebug();
    }



}
