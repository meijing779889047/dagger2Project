package com.project.dagger2.xeample1.mvp;

import android.os.Bundle;
import android.widget.TextView;

import com.project.dagger2.xeample1.R;
import com.project.dagger2.xeample1.mvp.component.AppComponent;
import com.project.dagger2.xeample1.mvp.component.DaggerMvpActivityComponent;
import com.project.dagger2.xeample1.mvp.module.MvpActivityModule;
import com.project.dagger2.xeample1.mvp.presneter.MvpActivityPresnter;

import javax.inject.Inject;

public class MvpActivity extends BaseActivity {

    private TextView tvData;

    @Inject
    MvpActivityPresnter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        tvData= (TextView) findViewById(R.id.tv);
        presenter.showUserName();
    }

    @Override
    protected void setUpActivityComponent(AppComponent mAppComponent) {
        DaggerMvpActivityComponent.builder()
                .appComponent(mAppComponent)
                .mvpActivityModule(new MvpActivityModule(this))
                .build()
                .inject(this);
    }
    public void setTextView(String username){
        tvData.setText(username);
    }
}
