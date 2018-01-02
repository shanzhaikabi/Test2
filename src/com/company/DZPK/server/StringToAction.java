package com.company.DZPK.server;

import com.company.DZPK.controller.LoginClient;
import com.company.DZPK.controller.LoginServer;
import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class StringToAction {
    public static void StringToAction(String string){
        String[] arr = string.split("\\s+");
        switch(arr[0]){
            case "actionCheckLogin" :
                LoginServer.CheckLoginFromServer(string);
                break;
            case "actionGetUserData" :
                break;
        }
    }

    public static String ActionGetUserDataByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("actionGetUserData")) return null;
        return arr[1];
    }

    public static UserData ActionCheckLoginByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("actionCheckLogin")) return null;
        UserData userData = new UserData();
        userData.setUsername(arr[1]);
        userData.setPassword(arr[2]);
        return userData;
    }
}