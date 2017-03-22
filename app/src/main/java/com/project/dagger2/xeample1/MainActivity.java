package com.project.dagger2.xeample1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.dagger2.xeample1.ui.DependienceActivity;
import com.project.dagger2.xeample1.ui.ImplementWayOneActivity;
import com.project.dagger2.xeample1.ui.ImplementWayTwoActivity;
import com.project.dagger2.xeample1.ui.NamedActivity;
import com.project.dagger2.xeample1.ui.QualifierActivity;
import com.project.dagger2.xeample1.ui.ScopeActivity;
import com.project.dagger2.xeample1.ui.SingletonActivity;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity   implements View.OnClickListener{



    private   TextView tvInfo;

    private   Button   btnOneWay;
    private   Button   btnTwoWay;
    private   Button   btnNamed;
    private   Button   btnQualifier;
    private   Button   btnSingleton;
    private   Button   btnScope;
    private   Button   btnDependience;

    //需要注入依赖的对象  不能用privite修饰
    @Inject
    @Named("long")//用于标识区分
    protected  Cloth   mLongCloth;
    @Inject
    @Named("short")//用于标识区分
    protected  Cloth   mShortCloth;
    @Inject
    protected  Shoe    mShoe;


    @Inject
    @Type(1)
    protected  Cloths  shortCloths;
    @Inject
    @Type(2)
    protected  Cloths  longCloths;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化组件
        initView();


       DaggerClothComponent.builder().clothModule(new ClothModule()).build().inject(this);
       mShoe.setName("鞋子");
       tvInfo.setText("我现在有布料"+mLongCloth.getName()+"和"+mShortCloth.getName()+"和"+mShoe.getName()+"-->mShortCloth是否与mmLongCloth时用一个对象："+(mShortCloth==shortCloths.getCloth()));

    }

    /**
     * 初始化组件
     */
    private void initView() {
        tvInfo= (TextView) findViewById(R.id.tv_info);
        btnOneWay= (Button) findViewById(R.id.button_implement_way_one);
        btnOneWay.setOnClickListener(this);
        btnTwoWay= (Button) findViewById(R.id.button_implement_way_two);
        btnTwoWay.setOnClickListener(this);
        btnNamed= (Button) findViewById(R.id.button_named);
        btnNamed.setOnClickListener(this);
        btnQualifier= (Button) findViewById(R.id.button_qualifier);
        btnQualifier.setOnClickListener(this);
        btnSingleton= (Button) findViewById(R.id.button_singleton);
        btnSingleton.setOnClickListener(this);
        btnScope= (Button) findViewById(R.id.button_scope);
        btnScope.setOnClickListener(this);
        btnDependience= (Button) findViewById(R.id.button_dependience);
        btnDependience.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_implement_way_one://Dagger2实现方式1
                startActivity(new Intent(this, ImplementWayOneActivity.class));
                break;
            case R.id.button_implement_way_two://Dagger2实现方式2
                startActivity(new Intent(this, ImplementWayTwoActivity.class));
                break;
            case R.id.button_named://Dagger2实现方式2 使用named的注解
                startActivity(new Intent(this, NamedActivity.class));
                break;
            case R.id.button_qualifier://Dagger2实现方式2 使用qualifier
                startActivity(new Intent(this, QualifierActivity.class));
                break;
            case  R.id.button_singleton://Dagger2实现方式2 使用singleton
                startActivity(new Intent(this, SingletonActivity.class));
                break;
            case R.id.button_scope://Dagger2实现方式2 使用scope
                startActivity(new Intent(this, ScopeActivity.class));
                break;
            case R.id.button_dependience://Dagger2实现方式2 使用dependience
                startActivity(new Intent(this, DependienceActivity.class));
                break;
        }
    }
}
