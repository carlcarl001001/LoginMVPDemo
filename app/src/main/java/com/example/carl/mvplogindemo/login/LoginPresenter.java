package com.example.carl.mvplogindemo.login;

import com.example.carl.mvplogindemo.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginModel,LoginActivity,ILogin.VP>{

    @Override
    public LoginModel getModelInstance() {
        return new LoginModel(this);
    }

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) {
                try {
                    mModel.getContract().requestLogin(name,pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void responseLoginResult(boolean loginStatusResult) {
                mView.getContract().responseLoginResult(loginStatusResult);
            }
        };
    }

//    @Override
//    public void requestLogin(String name, String pwd) {
//        //校验请求信息，进行逻辑处理
//        // ...
//        try {
//            mModel.requestLogin(name,pwd);
//        } catch (Exception e) {
//            e.printStackTrace();
//            //异常处理
//            //保存日志
//        }
//    }
//
//    @Override
//    public void responseLoginResult(boolean loginStatusResult) {
//        //真实的开发过程中是要解析JSON数据的
//        //...
//        mView.responseLoginResult(loginStatusResult);
//    }
}
