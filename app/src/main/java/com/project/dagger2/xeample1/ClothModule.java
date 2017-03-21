package com.project.dagger2.xeample1;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述： 布料module类 提供需要依赖的对象实例   类似衣服提供商
 * 创建人：Administrator
 * 创建时间：2017/3/21 9:59
 * 修改人：Administrator
 * 修改时间：2017/3/21 9:59
 * 修改备注：
 * Version:  1.0.0
 */
@Module
public class ClothModule {


    //使用provide注解来标注返回依赖对象的方法  component会根据该注解去查找需要返回指定类型的方法
    @Provides
    @Named("long")
    @ScopePerActivity
//    @Singleton
    public   Cloth getLongCloth(){
          Cloth  bean=new Cloth();
          bean.setColor("绿色");
          bean.setName("长裤子");
          return   bean;
    }
    //使用provide注解来标注返回依赖对象的方法  component会根据该注解去查找需要返回指定类型的方法
    @Provides
    @Named("short")
    @ScopePerActivity
//    @Singleton
    public   Cloth getShortCloth(){
          Cloth  bean=new Cloth();
          bean.setColor("红色");
          bean.setName("短裤子");
          return   bean;
    }
    //使用provide注解来标注返回依赖对象的方法  component会根据该注解去查找需要返回指定类型的方法
//    @Singleton
    @ScopePerActivity
    @Provides
    @Type(1)
    public   Cloths getShortCloths(@Named("short") Cloth cloth){
          return   new Cloths(cloth);
    }
    //使用provide注解来标注返回依赖对象的方法  component会根据该注解去查找需要返回指定类型的方法
//    @Singleton
    @ScopePerActivity
    @Provides
    @Type(2)
    public   Cloths getlongCloths(@Named("long") Cloth cloth){
        return   new Cloths(cloth);
    }

}
