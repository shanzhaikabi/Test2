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
            if (gameThread.table.GetTableId() == tableId){
                Server.tableList.get(tableId).table.input("id " + String.valueOf(playerId) + " ready");
                return "success";
            }
        }
        return "failed";
    }
}
