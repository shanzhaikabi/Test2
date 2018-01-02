package com.company.DZPK.server;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class ActionToString {
    public static String checkLogin(String username,String password){
        return "actionCheckLogin " + username + " " + password;
    }

    public static String getUserData(String username){
        return "actionGetUserData " + username;
    }
}
