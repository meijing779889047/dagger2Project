package com.project.dagger2.xeample1.mvp.component;

import com.project.dagger2.xeample1.mvp.MvpActivity;
import com.project.dagger2.xeample1.mvp.MvpActivityScope;
import com.project.dagger2.xeample1.mvp.module.MvpActivityModule;
import com.project.dagger2.xeample1.mvp.presneter.MvpActivityPresnter;

import dagger.Component;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/23 17:45
 * 修改人：Administrator
 * 修改时间：2017/3/23 17:45
 * 修改备注：
 * Version:  1.0.0
 */
@MvpActivityScope
@Component(modules = MvpActivityModule.class,dependencies = AppComponent.class)
public interface MvpActivityComponent {

    MvpActivity inject(MvpActivity activity);

    MvpActivityPresnter  present();

}
