package com.project.dagger2.xeample1.mvp.component;

import android.app.Application;

import com.project.dagger2.xeample1.mvp.data.api.ApiService;
import com.project.dagger2.xeample1.mvp.data.api.ApiServiceModule;
import com.project.dagger2.xeample1.mvp.model.User;
import com.project.dagger2.xeample1.mvp.module.AppModule;
import com.project.dagger2.xeample1.mvp.module.AppServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/23 16:54
 * 修改人：Administrator
 * 修改时间：2017/3/23 16:54
 * 修改备注：
 * Version:  1.0.0
 */
@Singleton
@Component(modules = {AppModule.class,AppServiceModule.class, ApiServiceModule.class})
public interface AppComponent {


    Application getApplication();

    ApiService getService();

    User getUser();
}
