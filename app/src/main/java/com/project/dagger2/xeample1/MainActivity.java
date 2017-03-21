package com.project.dagger2.xeample1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

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



    private   TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo= (TextView) findViewById(R.id.tv_info);

       DaggerClothComponent.builder().clothModule(new ClothModule()).build().inject(this);



       mShoe.setName("鞋子");
       tvInfo.setText("我现在有布料"+mLongCloth.getName()+"和"+mShortCloth.getName()+"和"+mShoe.getName()+"-->mShortCloth是否与mmLongCloth时用一个对象："+(mShortCloth==shortCloths.getCloth()));

    }
}
