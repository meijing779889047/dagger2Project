package com.project.dagger2.xeample1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.dagger2.xeample1.R;
import com.project.dagger2.xeample1.singleton.DaggerSingletonComponent;
import com.project.dagger2.xeample1.singleton.SingletonBean;
import com.project.dagger2.xeample1.singleton.SingletonModule;

import javax.inject.Inject;
import javax.inject.Named;

public class SingletonActivity extends AppCompatActivity {

    private TextView tvData;

    @Inject
    @Named("way3")
    SingletonBean bean1;

    @Inject
    @Named("way3")
    SingletonBean bean2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);
        tvData= (TextView) findViewById(R.id.tv_data);
        DaggerSingletonComponent.builder().singletonModule(new SingletonModule()).build().inject(this);
        bean1.setName("张三");
        bean2.setName("李四");
        tvData.setText("通过Dagger2的实现方式2采用module获取的数据："+bean1.getName()+"和"+bean2.getName()+"-->bean1==bean2:"+(bean1==bean2));
    }



}
