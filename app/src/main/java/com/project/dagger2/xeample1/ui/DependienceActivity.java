package com.project.dagger2.xeample1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.dagger2.xeample1.R;

public class DependienceActivity extends AppCompatActivity {
//
//    @Inject
//    @Named("way3")
//    DependienceBean  bean1;
//
//    @Inject
//    HnPrefUtil   mHnPrefUtil1;
//    @Inject
//    HnPrefUtil   mHnPrefUtil2;

    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependience);
        tvData= (TextView) findViewById(R.id.tv_data);
//        bean1.setName("张三");
//        tvData.setText("通过Dagger2的实现方式2采用module获取的数据："+bean1.getName()+"--->(mHnPrefUtil===mHnPrefUtil1)"+(mHnPrefUtil1==mHnPrefUtil2));
    }
}
