package com.project.dagger2.xeample1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.project.dagger2.xeample1.R;
import com.project.dagger2.xeample1.mvp.MvpActivity;

public class MainActivity extends AppCompatActivity   implements View.OnClickListener{

    private   Button   btnOneWay;
    private   Button   btnTwoWay;
    private   Button   btnNamed;
    private   Button   btnQualifier;
    private   Button   btnSingleton;
    private   Button   btnScope;
    private   Button   btnDependience;
    private   Button   btnLazyProvier;
    private   Button   btnSubcomponent;
    private   Button   btnExmaple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化组件
        initView();
    }
    /**
     * 初始化组件
     */
    private void initView() {
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
        btnLazyProvier= (Button) findViewById(R.id.button_lazy_provider);
        btnLazyProvier.setOnClickListener(this);
        btnSubcomponent= (Button) findViewById(R.id.button_subcomponent);
        btnSubcomponent.setOnClickListener(this);
        btnExmaple= (Button) findViewById(R.id.button_example);
        btnExmaple.setOnClickListener(this);
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
            case R.id.button_lazy_provider://Dagger2实现方式2 使用alzy/provider
                startActivity(new Intent(this, LazyProviderActivity.class));
                break;
            case R.id.button_subcomponent://Dagger2实现方式2 使用subcomponent
                startActivity(new Intent(this, SubcomponentActivity.class));
                break;
            case R.id.button_example:// MVP+Dagger2结合使用
                startActivity(new Intent(this, MvpActivity.class));
                break;
        }
    }
}
