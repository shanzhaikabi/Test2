package com.company.DZPK.controller;

import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class YuyueServer {
    public static boolean Yuyue(UserData userData){
        for(UserData userData1:Server.userDataQueue){
            if (userData.getId() == userData.getId()) return false;
        }
        Server.userDataQueue.add(userData);
        return true;
    }

    public static String YuyueToClient(String string){
        UserData userData = StringToAction.ActionYuyue(string);
        int slot = StringToAction.ActionYuyueSlot(string);
        boolean yuyue = Yuyue(userData);
        String returnString = ActionToString.ReturnYuyue(yuyue,slot);
        return returnString;
    }
}
