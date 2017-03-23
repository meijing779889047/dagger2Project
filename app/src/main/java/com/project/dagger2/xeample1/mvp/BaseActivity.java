package com.project.dagger2.xeample1.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.project.dagger2.xeample1.MyApp;
import com.project.dagger2.xeample1.mvp.component.AppComponent;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/23 17:39
 * 修改人：Administrator
 * 修改时间：2017/3/23 17:39
 * 修改备注：
 * Version:  1.0.0
 */
public abstract class BaseActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpActivityComponent(MyApp.get(this).getAppComponent());
    }


    protected  abstract  void setUpActivityComponent(AppComponent mAppComponent);
}
