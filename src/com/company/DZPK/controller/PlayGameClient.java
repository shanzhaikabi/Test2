package com.company.DZPK.controller;

import com.company.DZPK.client.*;
import com.company.DZPK.client.ActionToString;
import com.company.DZPK.client.StringToAction;
import com.company.DZPK.frame.game_frame;
import com.company.DZPK.frame.main_frame;
import com.company.DZPK.tool.Localization;

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
        int id = StringToAction.GetIdWhenStart(string);
        int playerId = StringToAction.GetPlayerIdWhenStart(string);
        String nickName = StringToAction.GetPlayerNicknameWhenStart(string);
        if (nickName == null) return;
        game_frame.setPlayerNameLabel(nickName, playerId, id);
        game_frame.setPlayerLabel(Localization.money_string + " 200000",id);
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
        disableButton();
    }

    public static void updatePlayerLabel(String string){
        int id = StringToAction.updatePlayerLabelId(string);
        String str = StringToAction.updatePlayerLabel(string);
        game_frame.setPlayerLabel(str,id);
    }

    public static void updatePlayerNickname(String string){
        int id = StringToAction.updatePlayerNicknameId(string);
        int playerId = StringToAction.updatePlayerNicknamePlayerId(string);
        String str = StringToAction.updatePlayerNickname(string);
        game_frame.setPlayerNameLabel(str,playerId,id);
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
        if (game_frame.error_label.getText() == null || game_frame.error_label.getText().length() == 0)
        game_frame.error_label.setText(Localization.enable_string);
    }

    public static void disableButton(){
        game_frame.raise_button.setEnabled(false);
        game_frame.call_button.setEnabled(false);
        game_frame.all_in_button.setEnabled(false);
        game_frame.fold_button.setEnabled(false);
        game_frame.error_label.setText("");
    }

    public static void raise(int money,int id,int table_id){
        String string = ActionToString.sendMessageToServer("raise",id,money,table_id);
        Client.sendThread.setIs(string);
    }

    public static void call(int money,int id,int table_id){
        String string = ActionToString.sendMessageToServer("call",id,0,table_id);
        Client.sendThread.setIs(string);
    }

    public static void fold(int money,int id,int table_id){
        String string = ActionToString.sendMessageToServer("fold",id,0,table_id);
        Client.sendThread.setIs(string);
    }

    public static void all_in(int money,int id,int table_id){
        String string = ActionToString.sendMessageToServer("all_in",id,0,table_id);
        Client.sendThread.setIs(string);
    }

    public static void setError(String string){
        String str = StringToAction.getError(string);
        game_frame.error_label.setText(str);
    }
}
