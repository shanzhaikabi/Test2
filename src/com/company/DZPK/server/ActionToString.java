package com.company.DZPK.server;

import com.company.DZPK.controller.Card;
import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class ActionToString {
    public static String CheckLogin(boolean check){
        return "returnCheckLogin " + String.valueOf(check);
    }

    public static String Register(boolean register){
        return "returnRegister " + String.valueOf(register);
    }

    public static String GetUserData(UserData userData){
        return "returnUserData " + String.valueOf(userData.getId()) + " " + userData.getUsername() + " " + userData.getPassword() + " "
                + userData.getNickname() + " " + String.valueOf(userData.getPoint()) + " " + String.valueOf(userData.getRank());
    }

    public static String ReturnYuyue(boolean yuyue,int slot){
        return "returnYuyue " + String.valueOf(yuyue) + " " + String.valueOf(slot);
    }

    public static String ShowCardToPlayerSingle(Card card, int place){
        return "getCardSingle " + String.valueOf(card.getId()) + " " + String.valueOf(place);
    }
}
