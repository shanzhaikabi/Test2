package com.company.DZPK.controller;

import com.company.DZPK.client.ActionToString;
import com.company.DZPK.client.StringToAction;
import com.company.DZPK.frame.login_frame;
import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class LoginClient {
    public static void checkLoginFromServer(String string){
        boolean login = StringToAction.getCheckLoginByString(string);
        if (login == false){
            login_frame.setError_label(login_frame.login_error);
            return;
        }
        else{

        }
    }

    public static void checkLoginToServer(String username,String password){
        String string = ActionToString.checkLogin(username,password);
        //上传给服务器
    }
}
