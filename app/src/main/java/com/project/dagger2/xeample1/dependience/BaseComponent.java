package com.project.dagger2.xeample1.dependience;

import android.content.Context;
import android.content.SharedPreferences;

import com.project.dagger2.xeample1.util.HnPrefUtil;

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
@Component(modules = {BaseModule.class})
public interface BaseComponent {

  //是告诉依赖于BaseComponent的Component,BaseComponent能为你们提供HnPrefUtil对象
   Context getApplication();

   SharedPreferences getSharedPreferences();

   HnPrefUtil getHnPrefUtil();
}
