package com.project.dagger2.xeample1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.dagger2.xeample1.R;
import com.project.dagger2.xeample1.implementWayTwo.DaggerImplementWayTwoComponent;
import com.project.dagger2.xeample1.implementWayTwo.ImplementWayTwoBean;
import com.project.dagger2.xeample1.implementWayTwo.ImplementWayTwoModule;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Dagger2实现方式1  使用module实现
 */
public class ImplementWayTwoActivity extends AppCompatActivity {


    private TextView tvData;

    @Inject
    @Named("way1")
    ImplementWayTwoBean bean1;
    @Inject
    @Named("way2")
    ImplementWayTwoBean bean2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implement_way_two);
        tvData= (TextView) findViewById(R.id.tv_data);
        DaggerImplementWayTwoComponent.builder().implementWayTwoModule(new ImplementWayTwoModule()).build().inject(this);
        bean1.setName("张三");
        bean2.setName("李四");
        tvData.setText("通过Dagger2的实现方式2采用module获取的数据："+bean1.getName()+"和"+bean2.getName());
    }
}
