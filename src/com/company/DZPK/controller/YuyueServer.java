package com.company.DZPK.controller;

import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class YuyueServer {
    public static void Yuyue(UserData userData){
        Server.userDataQueue.add(userData);

    }

    public static String YuyueToClient(String string){
        UserData userData = StringToAction.ActionYuyue(string);

        String returnString = ActionToString.ReturnYuyue(false);
        return returnString;
    }
}
