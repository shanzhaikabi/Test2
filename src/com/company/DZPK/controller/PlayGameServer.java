package com.company.DZPK.controller;

import com.company.DZPK.server.*;

/**
 * Created by Shanzhai on 2018/1/3.
 */
public class PlayGameServer {
    public static String PlayerReady(String string) {
        int playerId = StringToAction.PlayerReady(string);
        int tableId = StringToAction.PlayerReadyTable(string);
        for(Server.GameThread gameThread : Server.tableList){
            if (gameThread.table.getTableId() == tableId){
                gameThread.input("ready",playerId);
                return "success";
            }
        }
        return "failed";
    }

    public static String action(String string){
        String str = StringToAction.getAction(string);
        int tableId = StringToAction.getActionTable(string);
        for(Server.GameThread gameThread : Server.tableList){
            if (gameThread.table.getTableId() == tableId){
                gameThread.input(str);
                return "success";
            }
        }
        return "failed";
    }
}
