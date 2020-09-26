package com.example.carl.mvplogindemo.base;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends  BasePresenter,CONTRACT> extends AppCompatActivity implements View.OnClickListener {

    public abstract CONTRACT getContract();

    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewID());
        initView();
        initListen();
        initData();
        mPresenter = getPresenterInstance();
        mPresenter.bindView(this);
    }

    //处理 响应错误信息
    public abstract <ERROR extends Object>void responseError(ERROR error,Throwable throwable);

    public abstract void initView();

    public abstract void initData();

    public abstract void initListen();

    public abstract int getContentViewID();

    public abstract P getPresenterInstance();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
    }

    public abstract void destroy();
}
