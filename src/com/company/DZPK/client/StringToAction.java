package com.company.DZPK.client;

import com.company.DZPK.controller.LoginClient;
import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class StringToAction {
    public static void StringToAction(String string){
        String[] arr = string.split("\\s+");
        switch(arr[0]){
            case "returnCheckLogin" :
                LoginClient.checkLoginFromServer(string);
                break;
            case "returnUserData" : break;
        }
    }

    public static UserData getUserDataByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnUserData")) return null;
        return new UserData(Integer.parseInt(arr[1]),arr[2],arr[3],arr[4],Integer.parseInt(arr[5]),Integer.parseInt(arr[6]));
    }

    public static boolean getCheckLoginByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnCheckLogin")) return false;
        return Boolean.parseBoolean(arr[1]);
    }
}
