package com.company.DZPK.controller;

import com.company.DZPK.frame.game_frame;
import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

import java.io.*;
import java.net.Socket;
import java.sql.Time;
import java.util.*;

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
    private Queue<String> stringQueue = new ArrayDeque<String>();
    public Holdem(Socket x)
    {
        socket = x;
    }

    public void input(String string){
        stringQueue.add(string);
    }

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
        sendMessage("resetGameflow");
        for(int i = 0;i < MAXPLAYER;i++) {//第i个为庄家
            String str = "============== Round " + String.valueOf(i + 1) + " ==============";
            sendMessage("updateGameflow " + str);
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
            int xmzp = (i + 1) % MAXPLAYER;
            int dmzp = (i + 2) % MAXPLAYER;
            str = playerList.get(xmzp).getNickname() + " " + game_frame.small_blind_string + " " + 800;
            sendMessage("updateGameflow " + str);
            str = playerList.get(dmzp).getNickname() + " " + game_frame.big_blind_string + " " + 1600;
            sendMessage("updateGameflow " + str);
            sendMessage("updatePlayerLabel " + playerList.get(xmzp).getId() + " " + game_frame.small_blind_string + " " + 800);
            sendMessage("updatePlayerLabel " + playerList.get(dmzp).getId() + " " + game_frame.big_blind_string + " " + 1600);
            //TODO:告知小盲大盲,PlayerID为(i + 1) % MAXPLAYER和(i + 2) % MAXPLAYER
            Player temp = playerList.get((i + 1) % MAXPLAYER);
            temp.setMoney(temp.getMoney() - 800);
            temp = playerList.get((i + 2) % MAXPLAYER);
            temp.setMoney(temp.getMoney() - 1600);
            mainpot = 2400;
            sendMessage("updateMainPot " + String.valueOf(mainpot));
            //翻牌前
            int j = 0;
            while(j < MAXPLAYER){
                //TODO:获取操作类型
                int cur = (i + j + 2) % MAXPLAYER;
                sendMessageToPlayer("yourTurn",playerList.get(cur).getPlayerId());

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

    public String read(int player) throws InterruptedException {
        sendMessageToPlayer("waitForRequire",playerList.get(player).getPlayerId());
        sleep(100);
        String string = stringQueue.poll();
        int trytime = 0;
        while(string == null || string.length() == 0){
            string = stringQueue.poll();
            sleep(100);
            trytime++;
            if (trytime > 100) return "id " + playerList.get(player).getPlayerId() + " fold ";
        }
        return string;
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
            setPlayerList();
            System.out.println("[Holdem]Set Player List Complete");
            sendMessage("start " + tableId);
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
                    sendPlayerMessageToPlayer(playerId);
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

    public int getIdByPlayerId(int playerId){
        for(int i = 0;i < playerList.size();i++){
            if (playerList.get(i).getPlayerId() == playerId) return i;
        }
        return -1;
    }

    public int getActionType(String string){
        return 0;
    }

    public int getActionMoney(String string){
        return 0;
    }

    public Socket getSocket(){return socket;}
}
