package com.company.DZPK.controller;

import com.company.DZPK.client.ActionToString;
import com.company.DZPK.client.Client;
import com.company.DZPK.client.StringToAction;
import com.company.DZPK.frame.game_frame;
import com.company.DZPK.frame.main_frame;
import com.company.DZPK.model.UserData;

import javax.swing.*;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class YuyueClient {
    public static void YuyueResultFromServer(String string){
        boolean yuyue = StringToAction.GetYuyueResultByString(string);
        //main_frame.window.frame.setVisible(false);
        //game_frame.window.show();
    }

    public static void YuyueToServer(UserData userData,int table){
        String string = ActionToString.SendYuyue(userData,table);
        Client.sendThread.setIs(string);
    }
}
