 package com.project.dagger2.xeample1.ui;

 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.widget.TextView;

 import com.project.dagger2.xeample1.R;
 import com.project.dagger2.xeample1.implementwayOne.DaggerImplementWayOneComponent;
 import com.project.dagger2.xeample1.implementwayOne.ImplementWayOneBean;

 import javax.inject.Inject;

 /**
  * Dagger2实现方式1  使用@inject注解对构造函数进行标注
  */
 public class ImplementWayOneActivity extends AppCompatActivity {

     private TextView  tvData;

     @Inject
     ImplementWayOneBean bean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implement_way_one);
        tvData= (TextView) findViewById(R.id.tv_data);
        DaggerImplementWayOneComponent.builder().build().inject(this);
        bean.setName("张三");
        tvData.setText("通过Dagger2的实现方式1采用@inject注解标注的构造函数获取的数据："+bean.getName());
    }
}
