package com.company.DZPK.server;

import com.company.DZPK.controller.GetUserDataServer;
import com.company.DZPK.controller.LoginServer;
import com.company.DZPK.controller.PlayGameServer;
import com.company.DZPK.controller.YuyueServer;
import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class StringToAction {
    public static String StringToAction(String string,Server.ServerThread thread){
        String[] arr = string.split("\\s+");
        switch(arr[0]){
            case "actionCheckLogin" :
                return LoginServer.CheckLoginToClient(string,thread);
            case "actionGetUserData" :
                return GetUserDataServer.GetUserDataToClient(string);
            case "actionRegister" :
                return LoginServer.RegisterToClient(string);
            case "actionYuyue" :
                return YuyueServer.YuyueToClient(string);
            case "playerReady" :
                return PlayGameServer.PlayerReady(string);
            case "raise" :
            case "fold" :
            case "all_in" :
            case "call" :
                return PlayGameServer.action(string);
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

    public static int ActionYuyueSlot(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("actionYuyue")) return -1;
        return Integer.parseInt(arr[7]);
    }

    public static int PlayerReady(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("playerReady")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static int PlayerReadyTable(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("playerReady")) return -1;
        return Integer.parseInt(arr[2]);
    }

    public static int getActionId(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("raise") && !arr[0].equals("fold") && !arr[0].equals("call") && !arr[0].equals("all_in")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static int getActionMoney(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("raise") && !arr[0].equals("fold") && !arr[0].equals("call") && !arr[0].equals("all_in")) return -1;
        return Integer.parseInt(arr[2]);
    }

    public static int getActionTable(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("raise") && !arr[0].equals("fold") && !arr[0].equals("call") && !arr[0].equals("all_in")) return -1;
        return Integer.parseInt(arr[3]);
    }

    public static String getAction(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("raise") && !arr[0].equals("fold") && !arr[0].equals("call") && !arr[0].equals("all_in")) return null;
        return string;
    }
}
