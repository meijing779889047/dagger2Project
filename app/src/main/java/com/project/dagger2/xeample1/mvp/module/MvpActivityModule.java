package com.project.dagger2.xeample1.mvp.module;

import com.project.dagger2.xeample1.mvp.MvpActivity;
import com.project.dagger2.xeample1.mvp.MvpActivityScope;
import com.project.dagger2.xeample1.mvp.model.User;
import com.project.dagger2.xeample1.mvp.presneter.MvpActivityPresnter;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/3/23 17:20
 * 修改人：Administrator
 * 修改时间：2017/3/23 17:20
 * 修改备注：
 * Version:  1.0.0
 */
@Module
public class MvpActivityModule {

    private MvpActivity mMvpActivityActivity;


    public MvpActivityModule(MvpActivity mMainActivity) {
        this.mMvpActivityActivity = mMainActivity;
    }

    @Provides
    @MvpActivityScope
    MvpActivity provideMvpActivity(){
        return  mMvpActivityActivity;
    }


    @Provides
    @MvpActivityScope
    MvpActivityPresnter provideMainActivityPresenter(MvpActivity mainActivity, User user) {
        return new MvpActivityPresnter(mainActivity, user);
    }

}
