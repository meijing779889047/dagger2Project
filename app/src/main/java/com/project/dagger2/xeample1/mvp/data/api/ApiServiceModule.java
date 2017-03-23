package com.project.dagger2.xeample1.mvp.data.api;

import android.app.Application;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/23 16:42
 * 修改人：Administrator
 * 修改时间：2017/3/23 16:42
 * 修改备注：
 * Version:  1.0.0
 */
@Module
public class ApiServiceModule {
    private static final String ENDPOINT="";

    @Provides
    @Singleton
    OkHttpClient  provideOkHttpClient(){
        OkHttpClient  client=new OkHttpClient();
        client.setConnectTimeout(60*1000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(60*1000,TimeUnit.MILLISECONDS);
        return  client;
    }


    @Provides
    @Singleton
    RestAdapter provideRestAdapter(Application application,OkHttpClient okHttpClient){
        RestAdapter.Builder builder=new RestAdapter.Builder();
        builder.setClient(new OkClient(okHttpClient)).setEndpoint(ENDPOINT);
        return  builder.build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(RestAdapter restAdapter){
        return  restAdapter.create(ApiService.class);
    }


}
