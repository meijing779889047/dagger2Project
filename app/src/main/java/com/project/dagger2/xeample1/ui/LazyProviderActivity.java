package com.project.dagger2.xeample1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.project.dagger2.xeample1.R;
import com.project.dagger2.xeample1.lazy_provider.DaggerLazyProviderComponent;
import com.project.dagger2.xeample1.lazy_provider.LazyProviderBean;
import com.project.dagger2.xeample1.lazy_provider.LazyProviderModule;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import dagger.Lazy;

public class LazyProviderActivity extends AppCompatActivity {
    private String TAG="LazyProviderActivity";

    private TextView tvData;

    @Inject
    @Named("way3")
    Lazy<LazyProviderBean>  bean1;

    @Inject
    @Named("way4")
    Provider<LazyProviderBean> bean2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_provider);
        tvData= (TextView) findViewById(R.id.tv_data);
        tvData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean1.get().setName("张三");
                Log.i(TAG,"bean1："+bean1.get().getName());
                bean2.get().setName("李四");
                Log.e(TAG,"bean2："+bean2.get().getName());
                bean1.get().setName("张三");
                Log.i(TAG,"bean1："+bean1.get().getName());
                bean2.get().setName("李四");
                Log.e(TAG,"bean2："+bean2.get().getName());
                bean1.get().setName("张三");
                Log.i(TAG,"bean1："+bean1.get().getName());
                LazyProviderBean datas = bean2.get();
                datas.setName("李四");
                Log.e(TAG,"bean2："+datas.getName());
            }
        });
        DaggerLazyProviderComponent.builder().lazyProviderModule(new LazyProviderModule()).build().inject(this);

    }
}
