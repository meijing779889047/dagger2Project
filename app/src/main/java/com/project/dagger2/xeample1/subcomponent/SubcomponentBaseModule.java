package com.project.dagger2.xeample1.subcomponent;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.project.dagger2.xeample1.util.HnPrefUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/22 19:01
 * 修改人：Administrator
 * 修改时间：2017/3/22 19:01
 * 修改备注：
 * Version:  1.0.0
 */
@Module
public class SubcomponentBaseModule {

    private  final Application mApplication;

    public SubcomponentBaseModule(Application mApplication) {
        this.mApplication = mApplication;
    }


    @Provides
    public  Context  getApplication(){
           return  mApplication;
    }


    @Provides
    public SharedPreferences getSharedPreferences(){
         return HnPrefUtil.init(mApplication.getApplicationContext());
    }


    @Provides
    @Singleton
    public HnPrefUtil getHnPrefUtil(){
        return new HnPrefUtil();
    }


}
