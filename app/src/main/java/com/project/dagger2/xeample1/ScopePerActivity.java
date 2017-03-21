package com.project.dagger2.xeample1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：自定义scope(作用域) 规定：在同一范围内，provide提供的对象会变成单例，创建指定依赖对象的方法只会调用一次
 *         1.自定义scop接口用scop注解标注
 *         2。在module中对用provides声明的方法用该scop进行定义（ScopePerActivity）
 *         3.要在对应的component上用scope（ScopePerActivity）去进行注解
 *         4.对于直接在构造函数用inject注解标注的对象，要在其对象的类上去声明scope（ScopePerActivity）
 * 创建人：Administrator
 * 创建时间：2017/3/21 16:31
 * 修改人：Administrator
 * 修改时间：2017/3/21 16:31
 * 修改备注：
 * Version:  1.0.0
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopePerActivity {
}
