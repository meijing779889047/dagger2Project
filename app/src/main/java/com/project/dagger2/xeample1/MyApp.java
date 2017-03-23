package com.project.dagger2.xeample1;

import android.app.Application;
import android.content.Context;

import com.project.dagger2.xeample1.dependience.BaseComponent;
import com.project.dagger2.xeample1.dependience.BaseModule;
import com.project.dagger2.xeample1.dependience.DaggerBaseComponent;
import com.project.dagger2.xeample1.mvp.component.AppComponent;
import com.project.dagger2.xeample1.mvp.component.DaggerAppComponent;
import com.project.dagger2.xeample1.mvp.data.api.ApiServiceModule;
import com.project.dagger2.xeample1.mvp.module.AppModule;
import com.project.dagger2.xeample1.mvp.module.AppServiceModule;
import com.project.dagger2.xeample1.subcomponent.DaggerSubcomponentBaseComponent;
import com.project.dagger2.xeample1.subcomponent.SubcomponentBaseComponent;
import com.project.dagger2.xeample1.subcomponent.SubcomponentBaseModule;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/22 19:26
 * 修改人：Administrator
 * 修改时间：2017/3/22 19:26
 * 修改备注：
 * Version:  1.0.0
 */
public class MyApp extends Application {

    private BaseComponent mBaseComponent;
    private SubcomponentBaseComponent mDaggerSubcomponentBaseComponent;

    private AppComponent mDaggerAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseComponent=  DaggerBaseComponent.builder().baseModule(new BaseModule(this)).build();
        mDaggerSubcomponentBaseComponent= DaggerSubcomponentBaseComponent.builder().subcomponentBaseModule(new SubcomponentBaseModule(this)).build();


        mDaggerAppComponent= DaggerAppComponent.builder().appModule(new AppModule(this))
                                                         .apiServiceModule(new ApiServiceModule())
                                                         .appServiceModule(new AppServiceModule())
                                                         .build();

    }


    public  SubcomponentBaseComponent  getSubcomponentBaseComponent(){
        return   mDaggerSubcomponentBaseComponent;
    }

    public  BaseComponent  getBaseComponent(){
        return   mBaseComponent;
    }

    public  AppComponent  getAppComponent(){
        return   mDaggerAppComponent;
    }



    public static MyApp get(Context context){
        return (MyApp) context.getApplicationContext();
    }

}
