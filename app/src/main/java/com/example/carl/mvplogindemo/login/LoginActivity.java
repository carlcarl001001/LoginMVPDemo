package com.example.carl.mvplogindemo.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carl.mvplogindemo.R;
import com.example.carl.mvplogindemo.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter,ILogin.VP> {
    private EditText etName;
    private EditText etPwd;
    private Button btLogin;

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) {
                mPresenter.getContract().requestLogin(name,pwd);
            }

            @Override
            public void responseLoginResult(boolean loginStatusResult) {
                Toast.makeText(LoginActivity.this,loginStatusResult?"登录成功":"登录失败",Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    public <ERROR> void responseError(ERROR error, Throwable throwable) {
        Toast.makeText(this,""+error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void initView() {
        etName = findViewById(R.id.et_name);
        etPwd = findViewById(R.id.et_pwd);
        btLogin = findViewById(R.id.bt_login);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListen() {
        btLogin.setOnClickListener(this);
    }

    @Override
    public int getContentViewID() {
        return R.layout.activity_login;
    }

    @Override
    public LoginPresenter getPresenterInstance() {
        return new LoginPresenter();
    }

    @Override
    public void destroy() {

    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String pwd = etPwd.getText().toString();
        //第一种方式 面向具体方法
        //requestLogin(name,pwd);

        //第二种方式 面向接口
        getContract().requestLogin(name,pwd);

    }

//    @Override
//    public void requestLogin(String name, String pwd) {
//        mPresenter.requestLogin(name,pwd);
//    }
//
//    @Override
//    public void responseLoginResult(boolean loginStatusResult) {
//        Toast.makeText(this,loginStatusResult?"登录成功":"登录失败",Toast.LENGTH_LONG).show();
//    }
}
