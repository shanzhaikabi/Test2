package com.company.DZPK.controller;

import com.company.DZPK.client.*;
import com.company.DZPK.client.ActionToString;
import com.company.DZPK.client.StringToAction;
import com.company.DZPK.frame.game_final_frame;
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

    public static void setEdPlayer(String string){
        Player player = StringToAction.getEdPlayerId(string);
        game_frame.ed_player_name[player.getId()].setText(player.getNickname());
        game_frame.ed_player_money[player.getId()].setText(String.valueOf(player.getMoney()));
        game_frame.setPlayerLabel(Localization.money_string + " " + String.valueOf(player.getMoney()),player.getId());
        if (player.getHand() != null && player.getHand()[0] != null){
            String str = player.getHand()[0].toString() + " " + player.getHand()[1].toString();
            game_frame.ed_player_detail[player.getId()].setText(str);
        }
        else {
            game_frame.ed_player_detail[player.getId()].setText(Localization.fold_string);
        }
        if (player.getMoneyRaised() > 0) {
            game_frame.ed_player_delta[player.getId()].setText("+" + String.valueOf(player.getMoneyRaised()));
        }
        else{
            game_frame.ed_player_delta[player.getId()].setText("");
        }
    }

    public static void setWinnerType(String string){
        game_frame.resetEd();
        int type = StringToAction.getWinnerType(string);
        switch (type){
            case -1:game_frame.ed_nuts_label.setText(Localization.fold_winner_string);break;
            case 0:game_frame.ed_nuts_label.setText(Localization.high_card_string);break;
            case 1:game_frame.ed_nuts_label.setText(Localization.one_pair_string);break;
            case 2:game_frame.ed_nuts_label.setText(Localization.two_pair_string);break;
            case 3:game_frame.ed_nuts_label.setText(Localization.three_of_a_kind_string);break;
            case 4:game_frame.ed_nuts_label.setText(Localization.straight_string);break;
            case 5:game_frame.ed_nuts_label.setText(Localization.flush_string);break;
            case 6:game_frame.ed_nuts_label.setText(Localization.full_house_string);break;
            case 7:game_frame.ed_nuts_label.setText(Localization.four_of_a_kind_string);break;
            case 8:game_frame.ed_nuts_label.setText(Localization.straight_flush_string);break;
        }
    }

    public static void setWinner(String string){
        String winner = StringToAction.getWinner(string);
        game_frame.ed_winner_label.setText(winner);
        String detail = StringToAction.getWinnerDetail(string);
        if (detail == null) game_frame.ed_nuts_detail_label.setText("");
        else if (detail.equals("fold")) game_frame.ed_nuts_detail_label.setText("");
        else game_frame.ed_nuts_detail_label.setText(detail);
        game_frame.ending_panel.setVisible(true);
    }

    /*public static void setFinal(String string){
        String arr[] = string.split("\\s+");
        for(int i = 1;i < (arr.length - 1) / 4;i++){
            game_final_frame.player_name
        }
    }*/
}
