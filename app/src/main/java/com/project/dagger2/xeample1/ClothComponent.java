package com.project.dagger2.xeample1;

import dagger.Component;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：Dagger2Example1
 * 类描述：Component注入组件   属性：modules class数组，声明该Component需要那些Module  component会去关联的Module中查找需要依赖对象的方法（用Provides标注的）
 *                                dependencies class数组 声明该Component的依赖关系
 * 创建人：Administrator
 * 创建时间：2017/3/21 10:07
 * 修改人：Administrator
 * 修改时间：2017/3/21 10:07
 * 修改备注：
 * Version:  1.0.0
 */
//@Singleton
@ScopePerActivity
@Component(modules = ClothModule.class)
public interface ClothComponent {


    /**
     * 通过该方法获取依赖需求方的对象传入component中，,Component类就会根据依赖需求方对象中声明的依赖关系来注入依赖需求方对象中所需要的对象
     * 需要注意的是,inject方法的参数不能用子类来接收,例如本Demo中,如果inject的参数是Activity,那么Dagger2就会报错
     * @param mainActivity
     */
    void inject(MainActivity mainActivity);



}
