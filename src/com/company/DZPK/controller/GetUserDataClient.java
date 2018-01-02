package com.company.DZPK.controller;

import com.company.DZPK.client.ActionToString;
import com.company.DZPK.client.Client;
import com.company.DZPK.client.StringToAction;
import com.company.DZPK.frame.main_frame;
import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class GetUserDataClient {
    public static void GetUserDataFromServer(String string){
        UserData userData = StringToAction.GetUserDataByString(string);
        main_frame.show(userData);
    }

    public static void GetUserDataToServer(String username){
        String string = ActionToString.GetUserData(username);
        Client.sendThread.setIs(string);
    }
}
