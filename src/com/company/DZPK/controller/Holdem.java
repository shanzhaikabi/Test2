package com.company.DZPK.controller;

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
