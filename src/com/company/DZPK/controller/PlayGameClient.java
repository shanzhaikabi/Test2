package com.company.DZPK.controller;

import com.company.DZPK.client.*;
import com.company.DZPK.frame.game_frame;
import com.company.DZPK.frame.main_frame;

/**
 * Created by Shanzhai on 2018/1/3.
 */
public class PlayGameClient {
    public static void StartGame(String string){
        int tableId = StringToAction.GetTableId(string);
        game_frame.show();
        game_frame.tableId = tableId;
        main_frame.frame.setVisible(false);
        game_frame.userData = main_frame.userData;
        Client.sendThread.setIs(ActionToString.SendPlayerReady(game_frame.userData,tableId));
    }

    public static void addPlayer(String string){
        int playerId = StringToAction.GetPlayerIdWhenStart(string);
        String nickName = StringToAction.GetPlayerNicknameWhenStart(string);
        if (nickName == null) nickName = "";
        game_frame.SetPlayerNameLabel(nickName, playerId);
    }
}
