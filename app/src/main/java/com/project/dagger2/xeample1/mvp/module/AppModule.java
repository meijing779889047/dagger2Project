package com.project.dagger2.xeample1.mvp.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：用于获取初始化的application
 * 创建人：Administrator
 * 创建时间：2017/3/23 16:55
 * 修改人：Administrator
 * 修改时间：2017/3/23 16:55
 * 修改备注：
 * Version:  1.0.0
 */
@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    public Application provideAppLication(){
        return mApplication;
    }



}
