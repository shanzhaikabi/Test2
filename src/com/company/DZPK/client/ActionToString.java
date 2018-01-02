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
}
