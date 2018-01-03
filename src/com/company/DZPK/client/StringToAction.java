package com.company.DZPK.client;

import com.company.DZPK.controller.GetUserDataClient;
import com.company.DZPK.controller.LoginClient;
import com.company.DZPK.controller.PlayGameClient;
import com.company.DZPK.controller.YuyueClient;
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
            case "returnYuyue":
                YuyueClient.YuyueResultFromServer(string);
                break;
            case "start":
                PlayGameClient.StartGame(string);
                break;
            case "playerStart":
                PlayGameClient.addPlayer(string);
                break;
            case "getCardSingle":

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

    public static int GetYuyueResultSlotByString(String string) {
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnYuyue")) return -1;
        return Integer.parseInt(arr[2]);
    }

    public static int GetTableId(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("start")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static int GetPlayerIdWhenStart(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("playerStart")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static String GetPlayerNicknameWhenStart(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("playerStart")) return null;
        if (arr.length < 3) return null;
        return arr[2];
    }

    public static int GetCardSingleId(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("getCardSingle")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static int GetCardSinglePlace(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("getCardSingle")) return -1;
        return Integer.parseInt(arr[2]);
    }
}
