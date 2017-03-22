package com.project.dagger2.xeample1.implementWayTwo;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：Module类 用module注解进行标注，内部提供返回所需依赖对象的方法，使用provides进行注解
 * 创建人：Administrator
 * 创建时间：2017/3/22 14:15
 * 修改人：Administrator
 * 修改时间：2017/3/22 14:15
 * 修改备注：
 * Version:  1.0.0
 */
@Module
public class ImplementWayTwoModule {

    @Provides
    @Named("way1")
    public  ImplementWayTwoBean  getImplementWayTwoBean1(){
         return  new  ImplementWayTwoBean();
    }

    @Provides
    @Named("way2")
    public  ImplementWayTwoBean  getImplementWayTwoBean2(){
        return  new  ImplementWayTwoBean();
    }
}
