package com.project.dagger2.xeample1.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.dagger2.xeample1.R;
import com.project.dagger2.xeample1.dependience.DaggerDependienceComponent;
import com.project.dagger2.xeample1.dependience.DependienceBean;
import com.project.dagger2.xeample1.dependience.DependienceModule;
import com.project.dagger2.xeample1.MyApp;
import com.project.dagger2.xeample1.util.HnPrefUtil;

import javax.inject.Inject;
import javax.inject.Named;

public class DependienceActivity extends AppCompatActivity {

    private TextView tvData;

    @Inject
    @Named("way3")
    DependienceBean  bean1;

    @Inject
    SharedPreferences sp;
    @Inject
    SharedPreferences sp1;

    @Inject
    HnPrefUtil   mHnPrefUtil1;
    @Inject
    HnPrefUtil   mHnPrefUtil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependience);
        tvData= (TextView) findViewById(R.id.tv_data);
        DaggerDependienceComponent.builder().baseComponent(((MyApp)getApplication()).getBaseComponent()).dependienceModule(new DependienceModule()).build().inject(this);
        bean1.setName("张三");
        HnPrefUtil.setString("data","1");
        tvData.setText("通过Dagger2的实现方式2采用module获取的数据："+bean1.getName()+"--->(SharedPreferences1==SharedPreferences2)"+(mHnPrefUtil1==mHnPrefUtil2));
    }
}
