package com.project.dagger2.xeample1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.dagger2.xeample1.R;
import com.project.dagger2.xeample1.qualifier.DaggerQualifierComponent;
import com.project.dagger2.xeample1.qualifier.QualiferType;
import com.project.dagger2.xeample1.qualifier.QualifierBean;
import com.project.dagger2.xeample1.qualifier.QualifierModule;

import javax.inject.Inject;

public class QualifierActivity extends AppCompatActivity {
        private TextView tvData;

        @Inject
        @QualiferType(1)
        QualifierBean bean1;
        @Inject
        @QualiferType(2)
        QualifierBean bean2;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualifier);
        tvData= (TextView) findViewById(R.id.tv_data);
        DaggerQualifierComponent.builder().qualifierModule(new QualifierModule()).build().inject(this);
        bean1.setName("张三");
        bean2.setName("李四");
        tvData.setText("通过Dagger2的实现方式2采用module获取的数据："+bean1.getName()+"和"+bean2.getName());
    }
}
