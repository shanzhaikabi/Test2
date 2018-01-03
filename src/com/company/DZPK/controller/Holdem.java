package com.company.DZPK.controller;

import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Holdem {
    private Socket socket = null;
    private BufferedReader br = null;
    private InputStream is = null;
    private InputStreamReader isr = null;
    private List<Player> playerList = new ArrayList<Player>();
    public InputStream inputStream = null;
    public OutputStream outputStream = null;
    public Holdem(Socket x){socket = x;}
    public void setPlayerList(){
        UserData userData;
        for(int i = 0;i < 2;i++){
            userData = Server.userDataQueue.poll();
            Player player = new Player(playerList.size() + 1, userData.getId(), userData.getNickname());
            playerList.add(player);
        }
    }
    public void play(){

    }

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
            System.out.println("set player list");
            setPlayerList();
            sendMessage("start game");
            play();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Socket getSocket(){return socket;}
}
