package com.company.DZPK.server;

import com.company.DZPK.controller.GetUserDataServer;
import com.company.DZPK.controller.LoginServer;
import com.company.DZPK.controller.YuyueServer;
import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class StringToAction {
    public static String StringToAction(String string){
        String[] arr = string.split("\\s+");
        switch(arr[0]){
            case "actionCheckLogin" :
                return LoginServer.CheckLoginToClient(string);
            case "actionGetUserData" :
                return GetUserDataServer.GetUserDataToClient(string);
            case "actionRegister" :
                return LoginServer.RegisterToClient(string);
            case "actionYuyue" :
                return YuyueServer.YuyueToClient(string);
        }
        return null;
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

    public static UserData ActionRegisterByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("actionRegister")) return null;
        UserData userData = new UserData();
        userData.setUsername(arr[1]);
        userData.setPassword(arr[2]);
        return userData;
    }

    public static UserData ActionYuyue(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("actionYuyue")) return null;
        return new UserData(Integer.parseInt(arr[1]),arr[2],arr[3],arr[4],Integer.parseInt(arr[5]),Integer.parseInt(arr[6]));
    }
}
