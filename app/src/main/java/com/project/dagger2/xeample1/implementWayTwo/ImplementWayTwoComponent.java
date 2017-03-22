package com.project.dagger2.xeample1.implementWayTwo;

import com.project.dagger2.xeample1.ui.ImplementWayTwoActivity;

import dagger.Component;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：Component接口类，注入器 使用Component注解进行标注
 *       有两个属性   modules      class数组 声明该Component需要那些Module  component会去关联的Module中查找需要依赖对象的方法（用Provides标注的）
 *                   dependencies class数组 声明该Component的依赖关系
 * 创建人：Administrator
 * 创建时间：2017/3/22 14:22
 * 修改人：Administrator
 * 修改时间：2017/3/22 14:22
 * 修改备注：
 * Version:  1.0.0
 */
@Component(modules = ImplementWayTwoModule.class)
public interface ImplementWayTwoComponent {

    void   inject(ImplementWayTwoActivity  mImplementWayTwoActivity);
}
