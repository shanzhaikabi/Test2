package com.company.DZPK.client;

import com.company.DZPK.model.UserData;
import com.company.DZPK.tool.ToString;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class ActionToString {
    public static String CheckLogin(String username,String password){
        return "actionCheckLogin " + username + " " + password;
    }

    public static String Register(String username,String password){
        return "actionRegister " + username + " " + password;
    }

    public static String GetUserData(String username){
        return "actionGetUserData " + username;
    }

    public static String SendYuyue(UserData userData,int table){
        return "actionYuyue " + ToString.UserDataToString(userData) + " " + String.valueOf(table);
    }

    public static String SendPlayerReady(UserData userData,int tableId){
        return "playerReady " + String.valueOf(userData.getId()) + " " + String.valueOf(tableId);
    }

    public static String sendMessageToServer(String type,int id,int money){
        return type + " " + String.valueOf(money) + " " + String.valueOf(id);
    }

}
