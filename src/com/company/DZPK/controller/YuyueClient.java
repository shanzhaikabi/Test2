package com.company.DZPK.controller;

import com.company.DZPK.client.ActionToString;
import com.company.DZPK.client.Client;
import com.company.DZPK.client.StringToAction;
import com.company.DZPK.frame.main_frame;
import com.company.DZPK.model.UserData;

import javax.swing.*;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class YuyueClient {
    public static void YuyueResultFromServer(String string){
        boolean yuyue = StringToAction.GetYuyueResultByString(string);
        if (yuyue){
            int slot = StringToAction.GetYuyueResultSlotByString(string);
            switch (slot){
                case 1:
                    main_frame.game_combo_1.setEnabled(false);
                    main_frame.yuyue_button_1.setEnabled(false);
                    break;
                case 2:
                    main_frame.game_combo_2.setEnabled(false);
                    main_frame.yuyue_button_2.setEnabled(false);
                    break;
                case 3:
                    main_frame.game_combo_3.setEnabled(false);
                    main_frame.yuyue_button_3.setEnabled(false);
                    break;
            }
        }
    }

    public static void YuyueToServer(UserData userData,int slot){
        String string = ActionToString.SendYuyue(userData,slot);
        Client.sendThread.setIs(string);
    }
}
