package com.example.retrofit.base;

import android.app.Application;

import com.example.retrofit.managers.ImageManager;

/**
 * Created by Administrator on 2016/5/16.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageManager.getInstace().init(this);
    }



}
