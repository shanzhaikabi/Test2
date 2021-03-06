package com.company.DZPK.controller;

import com.company.DZPK.client.ActionToString;
import com.company.DZPK.client.Client;
import com.company.DZPK.client.StringToAction;
import com.company.DZPK.frame.login_frame;

import java.util.Optional;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class LoginClient {
    public static void CheckLoginFromServer(String string){
        boolean login = StringToAction.GetCheckLoginByString(string);
        if (login == false){
            login_frame.setError_label(login_frame.login_error);
            return;
        }
        else{
            login_frame.GetUserData();
        }
    }

    public static void CheckRegisterFromServer(String string){
        boolean register = StringToAction.GetRegisterByString(string);
        if (register == false){
            login_frame.setError_label(login_frame.register_error);
            return;
        }
        else{
            login_frame.setError_label(login_frame.register_success);
            return;
        }
    }

    public static void CheckLoginToServer(String username,String password){
        String string = ActionToString.CheckLogin(username,password);
        Client.sendThread.setIs(string);
    }

    public static void CheckRegisterToServer(String username,String password){
        String string = ActionToString.Register(username,password);
        Client.sendThread.setIs(string);
    }

}
