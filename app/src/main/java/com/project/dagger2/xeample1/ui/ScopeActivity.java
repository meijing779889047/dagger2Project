package com.project.dagger2.xeample1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.dagger2.xeample1.R;
import com.project.dagger2.xeample1.scope.DaggerScopeComponent;
import com.project.dagger2.xeample1.scope.ScopeBean;
import com.project.dagger2.xeample1.scope.ScopeModule;
import com.project.dagger2.xeample1.scope.ScopeType;

import javax.inject.Inject;

public class ScopeActivity extends AppCompatActivity {
    private TextView tvData;

    @Inject
    @ScopeType(1)
    ScopeBean bean1;

    @Inject
    @ScopeType(1)
    ScopeBean bean2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scope);
        tvData= (TextView) findViewById(R.id.tv_data);
        DaggerScopeComponent.builder().scopeModule(new ScopeModule()).build().inject(this);
        bean1.setName("张三");
        bean2.setName("李四");
        tvData.setText("通过Dagger2的实现方式2采用module获取的数据："+bean1.getName()+"和"+bean2.getName()+"-->bean1==bean2:"+(bean1==bean2));
    }

}
