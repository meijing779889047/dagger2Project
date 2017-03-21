package com.project.dagger2.xeample1;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/21 11:57
 * 修改人：Administrator
 * 修改时间：2017/3/21 11:57
 * 修改备注：
 * Version:  1.0.0
 */
public class Cloths {

    private  Cloth  cloth;

    public Cloths(Cloth cloth) {
        this.cloth = cloth;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }
}
