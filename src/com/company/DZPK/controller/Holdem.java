package com.company.DZPK.controller;

import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

import java.io.*;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Holdem {
    private final int MAXPLAYER = 2;
    private Random random = new Random(11);
    private Socket socket = null;
    private BufferedReader br = null;
    private InputStream is = null;
    private InputStreamReader isr = null;
    private List<Player> playerList = new ArrayList<Player>();
    public OutputStream outputStream = null;
    private PrintWriter pw = null;
    public Holdem(Socket x){socket = x;}
    public void setPlayerList(){
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
    //给桌上的每个玩家发送消息
    public void sendMessage(String message){
        System.out.println("message send");
        for(Player player : playerList){
            Server.threadMap.get(player.getPlayerId()).sendMessage(message);
        }
    }

    public void load(){
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is,"utf-8");
            br = new BufferedReader(isr);
            outputStream = socket.getOutputStream();
            pw = new PrintWriter(outputStream);
            //System.out.println("set player list");
            setPlayerList();
            //sendMessage("start game");
            play();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Socket getSocket(){return socket;}
}
