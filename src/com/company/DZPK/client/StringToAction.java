package com.company.DZPK.client;

import com.company.DZPK.controller.GetUserDataClient;
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
                LoginClient.CheckLoginFromServer(string);
                break;
            case "returnUserData" :
                GetUserDataClient.GetUserDataFromServer(string);
                break;
            case "returnRegister":
                LoginClient.CheckRegisterFromServer(string);
                break;
            case "start":
                System.out.println("game start");
                break;
        }
    }

    public static UserData GetUserDataByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnUserData")) return null;
        return new UserData(Integer.parseInt(arr[1]),arr[2],arr[3],arr[4],Integer.parseInt(arr[5]),Integer.parseInt(arr[6]));
    }

    public static boolean GetCheckLoginByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnCheckLogin")) return false;
        return Boolean.parseBoolean(arr[1]);
    }

    public static boolean GetRegisterByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnRegister")) return false;
        return Boolean.parseBoolean(arr[1]);
    }

    public static boolean GetYuyueResultByString(String string) {
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnYuyue")) return false;
        return Boolean.parseBoolean(arr[1]);
    }
}
