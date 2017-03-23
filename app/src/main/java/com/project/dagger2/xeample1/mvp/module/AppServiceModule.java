package com.project.dagger2.xeample1.mvp.module;

import com.project.dagger2.xeample1.mvp.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：用于获取一个被初始化的user对象
 * 创建人：Administrator
 * 创建时间：2017/3/23 17:07
 * 修改人：Administrator
 * 修改时间：2017/3/23 17:07
 * 修改备注：
 * Version:  1.0.0
 */
@Module
public class AppServiceModule {

    @Provides
    User  providerUser(){
        User  user=new User();
        user.setId("1");
        user.setName("Dagger2+mvp的结合使用demo，详情请查看mvp的实例代码");
        return user;
    }
}
