package com.project.dagger2.xeample1.implementWayTwo;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：需要依赖的对象的实例类
 * 创建人：Administrator
 * 创建时间：2017/3/22 14:14
 * 修改人：Administrator
 * 修改时间：2017/3/22 14:14
 * 修改备注：
 * Version:  1.0.0
 */
public class ImplementWayTwoBean {

    private  String name;


    public ImplementWayTwoBean() {
    }

    public ImplementWayTwoBean(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
