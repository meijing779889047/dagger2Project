package com.project.dagger2.xeample1.implementwayOne;

import com.project.dagger2.xeample1.ui.ImplementWayOneActivity;

import dagger.Component;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：Component接口注入组件
 * 创建人：Administrator
 * 创建时间：2017/3/22 12:54
 * 修改人：Administrator
 * 修改时间：2017/3/22 12:54
 * 修改备注：
 * Version:  1.0.0
 */
@Component
public interface ImplementWayOneComponent {

    void   inject(ImplementWayOneActivity  mImplementWayOneActivity);
}
