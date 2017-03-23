package com.project.dagger2.xeample1.mvp.presneter;

import com.project.dagger2.xeample1.mvp.MvpActivity;
import com.project.dagger2.xeample1.mvp.model.User;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/23 17:37
 * 修改人：Administrator
 * 修改时间：2017/3/23 17:37
 * 修改备注：
 * Version:  1.0.0
 */
public class MvpActivityPresnter {

    private MvpActivity  mMvpActivityActivity;

    private User  user;


    public MvpActivityPresnter(MvpActivity mMvpActivityActivity, User user) {
        this.mMvpActivityActivity = mMvpActivityActivity;
        this.user = user;
    }


    public void showUserName(){
         mMvpActivityActivity.setTextView(user.getName());
    }
}
