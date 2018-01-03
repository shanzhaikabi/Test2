package com.company.DZPK.controller;

import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

import java.io.*;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class Holdem {
    private final int MAXPLAYER = 2;
    private int tableId;
    private Random random = new Random(System.currentTimeMillis());
    private Socket socket = null;
    private BufferedReader br = null;
    private InputStream is = null;
    private InputStreamReader isr = null;
    private List<Player> playerList = new ArrayList<Player>();
    public OutputStream outputStream = null;
    private PrintWriter pw = null;
    public Holdem(Socket x){socket = x;}

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public void setPlayerList(){
        UserData userData;
        for(int i = 0;i < MAXPLAYER;i++){
            userData = Server.userDataQueue.poll();
            Player player = new Player(playerList.size() + 1, userData.getId(), userData.getNickname());
            playerList.add(player);
        }
    }
    public void play(){
        for(int i = 0;i < MAXPLAYER;i++) {//第i个为庄家
            List<Card> cards = new ArrayList<Card>();
            Vector<Integer> sidepot = new Vector<Integer>();
            int mainpot = 0;
            for (int j = 0; j < 52; j++)
                cards.add(new Card(j));
            int tmp = 0;
            for (int j = 0; j < MAXPLAYER; j++) {
                for (int k = 0; k < 2; k++) {
                    int t = random.nextInt(52 - tmp);
                    int curPlayer = (i + j) % MAXPLAYER;
                    Card card = cards.get(t);
                    playerList.get(curPlayer).setHand(k, card);
                    cards.remove(t);
                    sendMessageToPlayer(ActionToString.ShowCardToPlayerSingle(card,k),playerList.get(curPlayer).getPlayerId());
                    tmp++;
                }
            }
            //TODO:告知小盲大盲,PlayerID为(i + 1) % MAXPLAYER和(i + 2) % MAXPLAYER
            Player temp = playerList.get((i + 1) % MAXPLAYER);
            temp.setMoney(temp.getMoney() - 800);
            temp = playerList.get((i + 2) % MAXPLAYER);
            temp.setMoney(temp.getMoney() - 1600);
            mainpot = 2400;
            //翻牌前
            int j = 0;
            while(j < MAXPLAYER){
                //TODO:获取操作类型
                int cur = (i + j + 2) % MAXPLAYER;

            }
        }
    }
    //给桌上的每个玩家发送消息
    public void sendMessage(String message){
        System.out.println("message send");
        for(Player player : playerList){
            Server.threadMap.get(player.getPlayerId()).sendMessage(message);
        }
    }

    public void sendMessageToPlayer(String message,int playerId){
        Server.threadMap.get(playerId).sendMessage(message);
    }

    public void sendPlayerMessageToPlayer(int playerId){
        for(int i = 0;i < playerList.size();i++){
            sendMessageToPlayer("playerStart " + String.valueOf(i + 1) + " " + playerList.get(i).getNickname(),playerId);
        }
        for(int i = playerList.size();i < 6;i++){
            sendMessageToPlayer("playerStart " + String.valueOf(i + 1) + " " + " ",playerId);
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
            sendMessage("start " + tableId);
            sleep(100);
            for(int i = 0;i < playerList.size();i++){
                String string = br.readLine();
                while(string == null || string.length() == 0){
                    string = br.readLine();
                    sleep(50);
                }
                String arr[] = string.split("\\s+");
                System.out.println("server:" + string + string.length());
                if (arr[0] == "id"){
                    int playerId = Integer.valueOf(arr[1]);
                    sendPlayerMessageToPlayer(playerId);
                }
            }
            System.out.println("Play!!!");
            play();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public Socket getSocket(){return socket;}
}
