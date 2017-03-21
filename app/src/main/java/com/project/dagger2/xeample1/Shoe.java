package com.project.dagger2.xeample1;

import javax.inject.Inject;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/21 10:56
 * 修改人：Administrator
 * 修改时间：2017/3/21 10:56
 * 修改备注：
 * Version:  1.0.0
 */
@ScopePerActivity
public class Shoe {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Inject
    public Shoe() {
    }


}
