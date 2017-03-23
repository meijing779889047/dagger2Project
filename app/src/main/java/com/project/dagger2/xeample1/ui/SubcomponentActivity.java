package com.project.dagger2.xeample1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.dagger2.xeample1.R;
import com.project.dagger2.xeample1.MyApp;
import com.project.dagger2.xeample1.subcomponent.subcomponentBean;
import com.project.dagger2.xeample1.subcomponent.subcomponentModule;
import com.project.dagger2.xeample1.util.HnPrefUtil;

import javax.inject.Inject;
import javax.inject.Named;

public class SubcomponentActivity extends AppCompatActivity {


    private TextView tv;

    @Inject
    HnPrefUtil mHnPrefUtil1;
    @Inject
    HnPrefUtil   mHnPrefUtil2;
    @Inject
    @Named("way3")
    subcomponentBean bean1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcomponent);
        tv = (TextView) findViewById(R.id.tv_data);
        MyApp application = (MyApp) getApplication();
        application.getSubcomponentBaseComponent().getSubMainComponent(new subcomponentModule()).inject(this);
        bean1.setName("张三");
        tv.setText("通过Dagger2的实现方式2采用module获取的数据："+bean1.getName()+"--->(SharedPreferences1==SharedPreferences2)"+(mHnPrefUtil1==mHnPrefUtil2));
    }
}
