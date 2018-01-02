package com.company.DZPK.controller;

import com.company.DZPK.model.UserData;
import com.company.DZPK.server.Server;

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
        while((userData = Server.userDataQueue.poll()) != null) {
            Player player = new Player(playerList.size() + 1, userData.getId(), userData.getNickname());
            playerList.add(player);
        }
    }
    public void play(){

    }
    public void load(){
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is,"utf-8");
            br = new BufferedReader(isr);
            setPlayerList();

            play();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Socket getSocket(){return socket;}
}
