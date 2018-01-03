package com.company.DZPK.controller;

import com.company.DZPK.client.*;
import com.company.DZPK.client.ActionToString;
import com.company.DZPK.client.StringToAction;
import com.company.DZPK.frame.game_frame;
import com.company.DZPK.frame.main_frame;
import com.company.DZPK.server.*;

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
        game_frame.setPlayerNameLabel(nickName, playerId);
    }

    public static void getCardSingle(String string){
        int id = StringToAction.GetCardSingleId(string);
        int place = StringToAction.GetCardSinglePlace(string);
        game_frame.addCard(id,place);
    }

    public static void updateGameflow(String string){
        String str = StringToAction.updateGameflow(string);
        game_frame.updateGameflow(str);
    }

    public static void resetGameflow(String string){
        String str = StringToAction.resetGameflow(string);
        if (str == null) str = "";
        game_frame.resetGameflow(str);
    }

    public static void updatePlayerLabel(String string){
        int id = StringToAction.updatePlayerLabelId(string);
        String str = StringToAction.updatePlayerLabel(string);
        game_frame.setPlayerLabel(str,id);
    }

    public static void updatePlayerNickname(String string){
        int id = StringToAction.updatePlayerNicknameId(string);
        String str = StringToAction.updatePlayerNickname(string);
        game_frame.setPlayerNameLabel(str,id);
    }

    public static void updateMainPot(String string){
        int mainPot = StringToAction.updateMainPot(string);
        game_frame.updateMainPot(mainPot);
    }

    public static void enableButton(){
        game_frame.raise_button.setEnabled(true);
        game_frame.call_button.setEnabled(true);
        game_frame.all_in_button.setEnabled(true);
        game_frame.fold_button.setEnabled(true);
        game_frame.error_label.setText(game_frame.enable_string);
    }

    public static void disableButton(){
        game_frame.raise_button.setEnabled(false);
        game_frame.call_button.setEnabled(false);
        game_frame.all_in_button.setEnabled(false);
        game_frame.fold_button.setEnabled(false);
        game_frame.error_label.setText("");
    }
}
