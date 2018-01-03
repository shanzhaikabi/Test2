package com.company.DZPK.controller;

import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;
import com.company.DZPK.tool.Localization;

import java.io.*;
import java.net.Socket;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Thread.sleep;

public class Holdem {
    private final int MAXPLAYER = 2;
    private final int WAIT = 0;
    private final int FOLDED = 1;
    private final int PLAYING = 2;
    private final int ALLIN = 3;
    private final int SMALLBLIND = 800;
    private final int BIGBILND = 1600;
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
            Player player = new Player(playerList.size(), userData.getId(), userData.getNickname());
            playerList.add(player);
        }
    }
    public int bet(List<Player> playerList,int i,int mainpot,int beginPlayer){
        int betPlayer = (i + beginPlayer) % MAXPLAYER, j = 1, moneyToCall = 1600;
        String str = "";
        while (j <= MAXPLAYER) {
            int cur = (betPlayer + j) % MAXPLAYER;
            Player curPlayer = playerList.get(cur);
            /*if(j == MAXPLAYER){
                if(beginPlayer != 2)
                    if(curPlayer.getMoneyRaised() == moneyToCall)break;
            }*/
            if (curPlayer.getStatus() == FOLDED) {
                j++;
                continue;
            }
            System.out.println("[Holdem]Wait for player " + playerList.get(cur).getPlayerId());
            String act = read(cur);
            int actionType = getActionType(act), tempMoney = 0;
            switch (actionType) {
                case 0:
                    curPlayer.setStatus(FOLDED);
                    str = curPlayer.getNickname() + " " + Localization.fold_string;
                    updateGameFlow(str);
                    updatePlayerLabel(curPlayer.getMoney(),curPlayer.getId(), Localization.fold_string);
                    break;
                case 1://跟注
                    tempMoney = moneyToCall - curPlayer.getMoneyRaised();
                    if(curPlayer.getMoney() < moneyToCall){
                        sendErrorMessage(curPlayer.getId(),Localization.raise_high_string);
                        continue;
                    }
                    curPlayer.setMoney(curPlayer.getMoney() - tempMoney);
                    curPlayer.setMoneyRaised(moneyToCall);
                    if (tempMoney > 0){//跟注操作，仅做注释，下同
                        str = curPlayer.getNickname() + " " + Localization.call_string + " " + curPlayer.getMoneyRaised();
                        updateGameFlow(str);
                        updatePlayerLabel(curPlayer.getMoney(),curPlayer.getId(), Localization.call_string,curPlayer.getMoneyRaised());
                    }
                    else{//过牌操作
                        str = curPlayer.getNickname() + " " + "check";
                        updateGameFlow(str);
                        updatePlayerLabel(curPlayer.getMoney(),curPlayer.getId(),"check");
                    }
                    mainpot += tempMoney;
                    updateMainPot(mainpot);
                    //如果raiseMoney为0则状态显示为check
                    //否则显示为Call...元
                    break;
                case 2://加注
                    tempMoney = getActionMoney(act);
                    if(tempMoney - curPlayer.getMoneyRaised() > curPlayer.getMoney()){
                        sendErrorMessage(curPlayer.getId(),Localization.raise_high_string);
                        continue;
                    }
                    if(tempMoney < moneyToCall){
                        sendErrorMessage(curPlayer.getId(),Localization.raise_low_string);
                        continue;
                    }
                    mainpot += tempMoney - curPlayer.getMoneyRaised();
                    updateMainPot(mainpot);
                    moneyToCall = tempMoney;
                    str = curPlayer.getNickname() + " " + Localization.raise_to_string + " " + moneyToCall;
                    updateGameFlow(str);
                    curPlayer.setMoney(curPlayer.getMoney() - moneyToCall + curPlayer.getMoneyRaised());
                    updatePlayerLabel(curPlayer.getMoney(),curPlayer.getId(), Localization.raise_string, moneyToCall);
                    j = 0;
                    betPlayer = curPlayer.getId();
                    curPlayer.setMoneyRaised(moneyToCall);
                    break;
                case 3://all in
                    tempMoney = curPlayer.getMoney();
                    mainpot += tempMoney - curPlayer.getMoneyRaised();
                    updateMainPot(mainpot);
                    curPlayer.setMoneyRaised(tempMoney);
                    moneyToCall = max(moneyToCall,tempMoney);
                    curPlayer.setMoney(0);
                    j = 0;betPlayer = curPlayer.getId();
                        /*else{
                            //not finished
                            sidepot.add(tempMoney);
                        }*/
                    break;
            }
            sendSuccessMessage(curPlayer.getId());
            j++;
        }
        return mainpot;
    }
    public int gameOver(List<Player> playerList){
        int cnt = 0,tmp = 0;
        for(Player player : playerList){
            if(player.getStatus() == FOLDED || player.getStatus() == ALLIN)cnt++;
            else tmp = player.getId();
        }
        if(cnt == MAXPLAYER - 1)return tmp;
        else return -1;
    }
    public void calcMoney(List<Player> playerlist,int mainpot,int result){//弃牌胜利
        sendMessage("winnerType -1");
        Player temp = playerList.get(result);
        temp.setMoney(temp.getMoney() + mainpot);
        for(Player player : playerlist){
            if (player.equals(temp)){
                sendPlayerMessageWhenGameOver(player,mainpot);
            }
            else sendPlayerMessageWhenGameOver(player,-1);
            player.setMoneyRaised(0);
            player.setStatus(PLAYING);
        }
        sendMessage("winner " + temp.getNickname() + " fold");
    }
    public void play(){
        sendMessage("resetGameflow");
        for(int i = 0;i < MAXPLAYER;i++) {//第i个为庄家
            String str = "============== Round " + String.valueOf(i + 1) + " ==============";
            sendMessage("updateGameflow " + str);
            List<Card> cards = new ArrayList<Card>();
            List<Card> publicCards = new ArrayList<Card>();
            //Vector<Integer> sidepot = new Vector<Integer>();
            int mainpot = 0;
            updateMainPot(mainpot);
            for (int j = 0; j < 52; j++)
                cards.add(new Card(j));
            for (int j = 0; j < MAXPLAYER; j++) {
                int curPlayer = (i + j) % MAXPLAYER;
                playerList.get(curPlayer).setStatus(PLAYING);
                for (int k = 0; k < 2; k++) {
                    int t = random.nextInt(cards.size());
                    Card card = cards.get(t);
                    playerList.get(curPlayer).setHand(k, card);
                    cards.remove(t);
                    sendMessageToPlayer(ActionToString.ShowCardToPlayerSingle(card, k), playerList.get(curPlayer).getPlayerId());
                }
            }
            int xmzp = (i + 1) % MAXPLAYER;
            int dmzp = (i + 2) % MAXPLAYER;
            str = playerList.get(xmzp).getNickname() + " " + Localization.small_blind_string + " " + SMALLBLIND;
            updateGameFlow(str);
            str = playerList.get(dmzp).getNickname() + " " + Localization.big_blind_string + " " + BIGBILND;
            updateGameFlow(str);
            Player temp = playerList.get((i + 1) % MAXPLAYER);
            temp.setMoney(temp.getMoney() - SMALLBLIND);temp.setMoneyRaised(SMALLBLIND);
            updatePlayerLabel(temp.getMoney(),xmzp, Localization.small_blind_string,SMALLBLIND);
            temp = playerList.get((i + 2) % MAXPLAYER);
            temp.setMoney(temp.getMoney() - BIGBILND);temp.setMoneyRaised(BIGBILND);
            updatePlayerLabel(temp.getMoney(),dmzp, Localization.big_blind_string,BIGBILND);
            mainpot = SMALLBLIND + BIGBILND;
            //翻牌前
            mainpot = bet(playerList,i,mainpot,2);
            int result = 0;
            if((result = gameOver(playerList)) != -1){
                calcMoney(playerList,mainpot,result);
                mainpot = 0;
                continue;
            }
            //翻三张牌
            int t = random.nextInt(cards.size());
            cards.remove(t);
            String cardString = Localization.board_string + " ";
            for(int k = 0;k < 3;k++){
                t = random.nextInt(cards.size());
                Card tempCard = cards.get(t);
                publicCards.add(tempCard);
                sendMessage(ActionToString.ShowCardToPlayerSingle(tempCard, k + 2));
                cardString += tempCard.getColorS() + tempCard.getNumS() + " ";
                cards.remove(t);
            }
            updateGameFlow(cardString);
            mainpot = bet(playerList,i,mainpot,0);
            if((result = gameOver(playerList)) != -1){
                calcMoney(playerList,mainpot,result);
                mainpot = 0;
                continue;
            }
            //翻一张牌
            t = random.nextInt(cards.size());
            cardString = Localization.board_string + " ";
            Card tempCard = cards.get(t);
            publicCards.add(tempCard);
            sendMessage(ActionToString.ShowCardToPlayerSingle(tempCard, 5));
            cardString += tempCard.getColorS() + tempCard.getNumS() + " ";
            cards.remove(t);
            updateGameFlow(cardString);
            mainpot = bet(playerList,i,mainpot,0);
            if((result = gameOver(playerList)) != -1){
                calcMoney(playerList,mainpot,result);
                mainpot = 0;
                continue;
            }
            //翻一张牌
            t = random.nextInt(cards.size());
            cardString = Localization.board_string + " ";
            tempCard = cards.get(t);
            publicCards.add(tempCard);
            sendMessage(ActionToString.ShowCardToPlayerSingle(tempCard, 6));
            cardString += tempCard.getColorS() + tempCard.getNumS() + " ";
            cards.remove(t);
            updateGameFlow(cardString);
            mainpot = bet(playerList,i,mainpot,0);
            if((result = gameOver(playerList)) != -1){//弃牌胜利
                calcMoney(playerList,mainpot,result);
            }else{
                List<Player> players = new ArrayList<Player>();
                for(Player player : playerList){
                    if(player.getStatus() == PLAYING || player.getStatus() == ALLIN){
                        players.add(player);
                    }
                    else sendPlayerMessageWhenGameOver(player,-1);
                }
                Compare compare = new Compare(players.size(),players,publicCards);
                sendMessage("winnerType " + String.valueOf(compare.nuts_num));
                int winnerNumber = compare.winner_num;
                int prize = mainpot / winnerNumber;
                compare.get_winner(players.size());
                for(int Id : compare.winner_id){
                    Player player = playerList.get(Id);
                    player.setMoney(player.getMoney() + prize);
                    sendPlayerMessageWhenGameOver(player,prize);
                    players.remove(player);
                    //TODO:你懂的
                }
                for (Player player:players){
                    sendPlayerMessageWhenGameOver(player,-1);
                }
                if (winnerNumber == 1){
                    Player player = playerList.get(compare.winner_id.get(0));
                    String string = "winner " + player.getNickname();
                    for(int j = 0;j < 5;j++){
                        string += compare.playernuts[player.getId()][j].toString() + " ";
                    }
                    sendMessage(string);
                }
                else{
                    sendMessage("winner " + Localization.multiWinner);
                }
            }
        }
    }
    //给桌上的每个玩家发送消息
    public void sendMessage(String message){
        System.out.println("[Broadcast]" + message);
        for(Player player : playerList){
            Server.threadMap.get(player.getPlayerId()).sendMessage(message);
        }
    }

    public void sendMessageToPlayer(String message,int playerId){
        Server.threadMap.get(playerId).sendMessage(message);
        System.out.println("[" + playerId + "]" + message);
    }

    public void sendPlayerMessageToPlayer(int playerId){
        for(int i = 0;i < playerList.size();i++){
            sendMessageToPlayer("playerStart " + String.valueOf(i) + " " + playerList.get(i).getPlayerId() + " " + playerList.get(i).getNickname(),playerId);
        }
        for(int i = playerList.size();i < 6;i++){
            sendMessageToPlayer("playerStart " + String.valueOf(i) + " " + " ",playerId);
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
            sleep(100);
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

    public void updatePlayerLabel(int money,int playerId,String str){
        sendMessage("updatePlayerLabel " + playerId + " " + Localization.money_string + " " + money + " " + str);
    }

    public void updatePlayerLabel(int money1,int playerId,String str,int money){
        sendMessage("updatePlayerLabel " + playerId + " " + Localization.money_string + " " + money1 + " " + str + " " + money);
    }

    public void sendErrorMessage(int id,String string){
        sendMessageToPlayer("actionFailed " + string,playerList.get(id).getPlayerId());
    }

    public void sendSuccessMessage(int id){
        sendMessageToPlayer("actionSuccess 0",playerList.get(id).getPlayerId());
    }

    public void sendPlayerMessageWhenGameOver(Player player,int delta){
        String string = "edPlayerMessage " + String.valueOf(player.getId()) + " " + String.valueOf(player.getPlayerId()) + " " + player.getNickname() + " ";
        string += player.getMoney() + " ";
        if (player.getStatus() == FOLDED){
            sendMessage(string);
            return;
        }
        string += player.getHand()[0].getId() + " " + player.getHand()[1].getId() + " ";
        string += String.valueOf(delta);
        sendMessage(string);
    }

    public void send_player_message_when_match_over()
    {
        String string ="match_over ";
        sendMessage(string);
    }

    public Socket getSocket(){return socket;}
}
