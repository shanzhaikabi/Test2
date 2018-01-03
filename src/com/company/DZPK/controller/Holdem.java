package com.company.DZPK.controller;

import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

import java.io.*;
import java.net.Socket;
import java.util.*;

import static java.lang.Thread.sleep;

public class Holdem {
    private final int MAXPLAYER = 2;
    private int tableId;
    private Random random = new Random(11);
    private Socket socket = null;
    private BufferedReader br = null;
    private InputStream is = null;
    private InputStreamReader isr = null;
    private List<Player> playerList = new ArrayList<Player>();
    private Queue<String> stringQueue = new ArrayDeque<String>();
    public OutputStream outputStream = null;
    private PrintWriter pw = null;

    public Holdem(Socket x)
    {
        socket = x;
    }

    public int GetTableId() {
        return tableId;
    }

    public void SetTableId(int tableId) {
        this.tableId = tableId;
    }

    public void SetPlayerList(){
        UserData userData;
        for(int i = 0;i < MAXPLAYER;i++){
            userData = Server.userDataQueue.poll();
            Player player = new Player(playerList.size() + 1, userData.getId(), userData.getNickname());
            playerList.add(player);
        }
    }
    public void play(){
        for(int i = 0;i < MAXPLAYER;i++){//第i个为庄家

        }
    }

    public void input(String string){
        stringQueue.add(string);
    }

    //给桌上的每个玩家发送消息
    public void SendMessage(String message){
        System.out.println("[Holdem]Message send");
        for(Player player : playerList){
            Server.threadMap.get(player.getPlayerId()).SendMessage(message);
        }
    }

    public void SendMessageToPlayer(String message,int playerId){
        Server.threadMap.get(playerId).SendMessage(message);
    }

    public void SendPlayerMessageToPlayer(int playerId){
        for(int i = 0;i < playerList.size();i++){
            SendMessageToPlayer("playerStart " + String.valueOf(i + 1) + " " + playerList.get(i).getNickname(),playerId);
        }
        for(int i = playerList.size();i < 6;i++){
            SendMessageToPlayer("playerStart " + String.valueOf(i + 1) + " " + " ",playerId);
        }
        System.out.println("[Holdem]Send Player Message To Player " + playerId);
    }

    public void load(){
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is,"UTF-8");
            br = new BufferedReader(isr);
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            System.out.println("[Holdem]Set Player List Start");
            SetPlayerList();
            System.out.println("[Holdem]Set Player List Complete");
            SendMessage("start " + tableId);
            sleep(100);
            System.out.println("[Holdem]Waiting for players");
            for(int i = 0;i < playerList.size();i++){
                String string = stringQueue.poll();
                while(string == null || string.length() == 0){
                    string = stringQueue.poll();
                    sleep(50);
                }
                String arr[] = string.split("\\s+");
                System.out.println("[Holdem]player" + String.valueOf(i + 1) + "'s message: " + string);
                if (arr[0].equals("id")){
                    int playerId = Integer.valueOf(arr[1]);
                    SendPlayerMessageToPlayer(playerId);
                }
            }
            System.out.println("[Holdem]Play");
            play();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public Socket getSocket(){
        return socket;
    }
}
