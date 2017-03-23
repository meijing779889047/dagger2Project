package com.project.dagger2.xeample1.subcomponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/22 19:03
 * 修改人：Administrator
 * 修改时间：2017/3/22 19:03
 * 修改备注：
 * Version:  1.0.0
 */
@Singleton
@Component(modules = {SubcomponentBaseModule.class})
public interface SubcomponentBaseComponent {



    //@Subcomponent使用的声明方式,声明一个返回值为子组件的方法,子组件需要什么Module,就在方法参数中添加什么
    subcomponentComponent getSubMainComponent(subcomponentModule module);
}
