package com.company.DZPK.tool;

import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class ToString {
    public static String UserDataToString(UserData userData){
        return String.valueOf(userData.getId()) + " " + userData.getUsername() + " " + userData.getPassword() + " "
                + userData.getNickname() + " " + String.valueOf(userData.getPoint()) + " " + String.valueOf(userData.getRank());
    }
}
