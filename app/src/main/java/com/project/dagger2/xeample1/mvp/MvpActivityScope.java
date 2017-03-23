package com.project.dagger2.xeample1.mvp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/23 17:42
 * 修改人：Administrator
 * 修改时间：2017/3/23 17:42
 * 修改备注：
 * Version:  1.0.0
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MvpActivityScope {
}
