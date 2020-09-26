package com.example.carl.mvplogindemo.login;

import com.example.carl.mvplogindemo.base.BaseModel;

public class LoginModel extends BaseModel<LoginPresenter,ILogin.M> {
    public LoginModel(LoginPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public ILogin.M getContract() {
        return new ILogin.M() {
            @Override
            public void requestLogin(String name, String pwd) throws Exception {
            //请求服务器登录接口，然后拿到服务器JSON数据
            //...
            if ("abc".equals(name)&&"123".equals(pwd)){
                mPresenter.getContract().responseLoginResult(true);
            }else {
                mPresenter.getContract().responseLoginResult(false);
            }
            }
        };
    }

//    @Override
//    public void requestLogin(String name, String pwd) throws Exception {
//        //请求服务器登录接口，然后拿到服务器JSON数据
//        //...
//        if ("abc".equals(name)&&"123".equals(pwd)){
//            mPresenter.responseLoginResult(true);
//        }else {
//            mPresenter.responseLoginResult(false);
//        }
//    }
}
