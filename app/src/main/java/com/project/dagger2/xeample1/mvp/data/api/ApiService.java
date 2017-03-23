package com.project.dagger2.xeample1.mvp.data.api;

import com.project.dagger2.xeample1.mvp.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：retorfit
 * 创建人：Administrator
 * 创建时间：2017/3/23 16:37
 * 修改人：Administrator
 * 修改时间：2017/3/23 16:37
 * 修改备注：
 * Version:  1.0.0
 */
public interface ApiService {

    @GET("/users")
    void getUserInfo(Callback<List<User>> callback);
}
