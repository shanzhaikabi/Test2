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
    private final int WAIT = 0;
    private final int FOLDED = 1;
    private final int PLAYING = 2;
    private final int ALLIN = 3;
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
                int curPlayer = (i + j) % MAXPLAYER;
                playerList.get(curPlayer).setStatus(PLAYING);
                for (int k = 0; k < 2; k++) {
                    int t = random.nextInt(52 - tmp);
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
            updateGameFlow(str);
            str = playerList.get(dmzp).getNickname() + " " + game_frame.big_blind_string + " " + 1600;
            updateGameFlow(str);
            updatePlayerLabel(xmzp,game_frame.small_blind_string,800);
            updatePlayerLabel(dmzp,game_frame.big_blind_string,1600);
            Player temp = playerList.get((i + 1) % MAXPLAYER);
            temp.setMoney(temp.getMoney() - 800);temp.setMoneyRaised(800);
            temp = playerList.get((i + 2) % MAXPLAYER);
            temp.setMoney(temp.getMoney() - 1600);temp.setMoneyRaised(1600);
            mainpot = 2400;
            updateMainPot(mainpot);
            //翻牌前
            int betPlayer = (i + 3) % MAXPLAYER,j = 0,moneyToCall = 1600,sidepotID = -1;
            //TODO:向玩家发送信息
            while(j < MAXPLAYER){
                int cur = (betPlayer + j + 2) % MAXPLAYER;
                Player curPlayer = playerList.get(cur);
                if(curPlayer.getStatus() == FOLDED){
                    j++;continue;
                }
                System.out.println("[Holdem]Wait for player " + playerList.get(cur).getPlayerId());
                String act = read(cur);
                int actionType = getActionType(act),tempMoney = 0;
                switch(actionType){
                    case 0:
                        curPlayer.setStatus(FOLDED);
                        str = curPlayer.getNickname() + " " + game_frame.fold_string;
                        updateGameFlow(str);
                        updatePlayerLabel(curPlayer.getId(),game_frame.fold_string);
                        break;
                    case 1://跟注
                        tempMoney = moneyToCall - curPlayer.getMoneyRaised();
                        curPlayer.setMoney(curPlayer.getMoney() - tempMoney);
                        /*if(sidepotID == -1)*/
                        mainpot += tempMoney;
                        /*else {
                        if (tempMoney > 0){
                            str = curPlayer.getNickname() + " " + game_frame.call_string + " " + curPlayer.getMoneyRaised();
                            updateGameFlow(str);
                            updatePlayerLabel(curPlayer.getId(),game_frame.call_string + " " + curPlayer.getMoneyRaised());
                        }
                        else{
                            str = curPlayer.getNickname() + " " + "check";
                            updateGameFlow(str);
                            updatePlayerLabel(curPlayer.getId(),"check");
                        }
                        if(sidepotID == -1)mainpot += tempMoney;
                        else {
                            int moneyInSidepot = sidepot.get(sidepotID);
                            sidepot.set(sidepotID,moneyInSidepot + tempMoney);
                        }
                        temp.setMoneyRaised(tempMoney + curPlayer.getMoneyRaised());
                        }*/
                        //如果raiseMoney为0则状态显示为check
                        //否则显示为Call...元
                        break;
                    case 2://加注
                        tempMoney = getActionMoney(act);
                        moneyToCall = tempMoney;
                        str = curPlayer.getNickname() + " " + game_frame.raise_string + " " + curPlayer.getMoneyRaised();
                        updateGameFlow(str);
                        updatePlayerLabel(curPlayer.getId(),game_frame.raise_string);
                        moneyToCall += tempMoney;
                        curPlayer.setMoney(curPlayer.getMoney() - moneyToCall);
                        j = 1;
                        betPlayer = curPlayer.getId() - 1;
                        //底池和sidepot如何变化
                        break;
                    case 3:
                        tempMoney = curPlayer.getMoney();
                        if(moneyToCall < tempMoney){
                            moneyToCall = curPlayer.getMoney();
                            curPlayer.setMoney(0);
                            j = 1;betPlayer = curPlayer.getId() - 1;
                        }
                        else{
                            //not finished
                            sidepot.add(tempMoney);
                        }
                        break;
                }
                j++;
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

    public String read(int player){
        sendMessageToPlayer("waitForRequire",playerList.get(player).getPlayerId());
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String string = stringQueue.poll();
        int tryTime = 0;
        while(string == null || string.length() == 0){
            string = stringQueue.poll();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tryTime++;
            //if (tryTime > 100) return "fold " + playerList.get(player).getPlayerId() + " 0";
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
        String[] arr = string.split("\\s+");
        switch (arr[0]){
            case "fold":return 0;
            case "call":return 1;
            case "raise":return 2;
            case "all_in":return 3;
        }
        return -1;
    }

    public int getActionMoney(String string){
        String[] arr = string.split("\\s+");
        return Integer.parseInt(arr[1]);
    }

    public void updateGameFlow(String string){
        sendMessage("updateGameflow " + string);
    }

    public void updateMainPot(int mainPot){
        sendMessage("updateMainPot " + String.valueOf(mainPot));
    }

    public void updatePlayerLabel(int id,String str){
        sendMessage("updatePlayerLabel " + id + " " + str);
    }

    public void updatePlayerLabel(int id,String str,int money){
        sendMessage("updatePlayerLabel " + id + " " + str + " " + money);
    }

    public Socket getSocket(){return socket;}
}
