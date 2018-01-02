package com.company.DZPK.server;

import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class ActionToString {
    public static String checkLogin(boolean check){
        return "returnCheckLogin " + String.valueOf(check);
    }

    public static String getUserData(UserData userData){
        return "returnUserData " + String.valueOf(userData.getId()) + " " + userData.getUsername() + " " + userData.getPassword() + " "
                + userData.getNickname() + " " + String.valueOf(userData.getPoint()) + " " + String.valueOf(userData.getRank());
    }
}
