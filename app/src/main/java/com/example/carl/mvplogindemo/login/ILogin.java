package com.example.carl.mvplogindemo.login;

public interface ILogin {
    public interface M {

        void requestLogin(String name,String pwd) throws Exception;

    }

    public interface VP {

        void requestLogin(String name,String pwd);

        void responseLoginResult(boolean loginStatusResult);
    }
}
