package com.project.dagger2.xeample1.implementwayOne;

import javax.inject.Inject;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：需要依赖对象的实例类
 * 创建人：Administrator
 * 创建时间：2017/3/22 12:44
 * 修改人：Administrator
 * 修改时间：2017/3/22 12:44
 * 修改备注：
 * Version:  1.0.0
 */
public class ImplementWayOneBean {


    private  String  name;

    @Inject
    public ImplementWayOneBean() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
