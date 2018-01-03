package com.company.DZPK.controller;

import com.company.DZPK.client.StringToAction;
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
        game_frame.gameflow_textarea.setText(game_frame.wait);
        main_frame.frame.setVisible(false);
    }

    public static void addPlayer(String string){
        int playerId = StringToAction.GetPlayerIdWhenStart(string);
        String nickName = StringToAction.GetPlayerNicknameWhenStart(string);
        if (nickName == null) nickName = "";
        game_frame.SetPlayerNameLabel(nickName, playerId);
    }
}
