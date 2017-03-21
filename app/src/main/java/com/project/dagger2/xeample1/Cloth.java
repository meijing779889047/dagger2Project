package com.project.dagger2.xeample1;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：布料类  需要依赖的对象  含有一些属性  类似于顾客需要买的衣服
 * 创建人：Administrator
 * 创建时间：2017/3/21 9:56
 * 修改人：Administrator
 * 修改时间：2017/3/21 9:56
 * 修改备注：
 * Version:  1.0.0
 */
public class Cloth {

    private   String  color;

    private   String  name;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "布料：" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
