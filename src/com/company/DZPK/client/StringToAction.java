package com.company.DZPK.client;

import com.company.DZPK.controller.*;
import com.company.DZPK.model.Card;
import com.company.DZPK.model.Player;
import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class StringToAction {
    public static void StringToAction(String string){
        String[] arr = string.split("\\s+");
        switch(arr[0]){
            case "returnCheckLogin" :
                LoginClient.CheckLoginFromServer(string);
                break;
            case "returnUserData" :
                GetUserDataClient.GetUserDataFromServer(string);
                break;
            case "returnRegister":
                LoginClient.CheckRegisterFromServer(string);
                break;
            case "returnYuyue":
                YuyueClient.YuyueResultFromServer(string);
                break;
            case "start":
                PlayGameClient.StartGame(string);
                break;
            case "playerStart":
                PlayGameClient.addPlayer(string);
                break;
            case "getCardSingle":
                PlayGameClient.getCardSingle(string);
                break;
            case "updateGameflow":
                PlayGameClient.updateGameflow(string);
                break;
            case "resetGameflow":
                PlayGameClient.resetGameflow(string);
                break;
            case "updatePlayerLabel":
                PlayGameClient.updatePlayerLabel(string);
                break;
            case "updatePlayerNickname":
                PlayGameClient.updatePlayerNickname(string);
                break;
            case "updateMainPot":
                PlayGameClient.updateMainPot(string);
                break;
            case "waitForRequire":
                PlayGameClient.enableButton();
                break;
            case "actionSuccess":
                PlayGameClient.disableButton();
                break;
            case "actionFailed":
                PlayGameClient.setError(string);
                break;
            case "edPlayerMessage":
                PlayGameClient.setEdPlayer(string);
                break;
            case "winnerType":
                PlayGameClient.setWinnerType(string);
                break;
            case "winner":
                PlayGameClient.setWinner(string);
                break;
            case "matchOver":
                PlayGameClient.setFinal(string);
                break;
        }
    }

    public static UserData GetUserDataByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnUserData")) return null;
        return new UserData(Integer.parseInt(arr[1]),arr[2],arr[3],arr[4],Integer.parseInt(arr[5]),Integer.parseInt(arr[6]));
    }

    public static boolean GetCheckLoginByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnCheckLogin")) return false;
        return Boolean.parseBoolean(arr[1]);
    }

    public static boolean GetRegisterByString(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnRegister")) return false;
        return Boolean.parseBoolean(arr[1]);
    }

    public static boolean GetYuyueResultByString(String string) {
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnYuyue")) return false;
        return Boolean.parseBoolean(arr[1]);
    }

    public static int GetYuyueResultSlotByString(String string) {
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("returnYuyue")) return -1;
        return Integer.parseInt(arr[2]);
    }

    public static int GetTableId(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("start")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static int GetIdWhenStart(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("playerStart")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static int GetPlayerIdWhenStart(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("playerStart")) return -1;
        if (arr.length < 3) return -1;
        return Integer.parseInt(arr[2]);
    }

    public static String GetPlayerNicknameWhenStart(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("playerStart")) return null;
        if (arr.length < 3) return null;
        return arr[3];
    }

    public static int GetCardSingleId(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("getCardSingle")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static int GetCardSinglePlace(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("getCardSingle")) return -1;
        return Integer.parseInt(arr[2]);
    }

    public static String updateGameflow(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("updateGameflow")) return null;
        return string.substring(arr[0].length());
    }

    public static String resetGameflow(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("resetGameflow")) return null;
        return string.substring(arr[0].length());
    }

    public static int updatePlayerLabelId(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("updatePlayerLabel")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static String updatePlayerLabel(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("updatePlayerLabel")) return null;
        return string.substring(arr[0].length() + arr[1].length() + 1);
    }

    public static int updatePlayerNicknameId(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("updatePlayerNickname")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static int updatePlayerNicknamePlayerId(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("updatePlayerNickname")) return -1;
        return Integer.parseInt(arr[2]);
    }

    public static String updatePlayerNickname(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("updatePlayerNickname")) return null;
        return string.substring(arr[0].length() + arr[1].length() + 1);
    }

    public static int updateMainPot(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("updateMainPot")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static String getError(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("actionFailed")) return null;
        return arr[1];
    }

    public static Player getEdPlayerId(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("edPlayerMessage")) return null;
        Player player = new Player(Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),arr[3]);
        player.setMoney(Integer.parseInt(arr[4]));
        if (arr.length <= 5) return player;
        if (Integer.parseInt(arr[5]) >= 0){
            player.setHand(0,new Card(Integer.parseInt(arr[5])));
            player.setHand(1,new Card(Integer.parseInt(arr[6])));
        }
        if (Integer.parseInt(arr[7]) > 0) player.setMoneyRaised(Integer.parseInt(arr[7]));
        return player;
    }

    public static int getWinnerType(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("winnerType")) return -1;
        return Integer.parseInt(arr[1]);
    }

    public static String getWinner(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("winner")) return null;
        return arr[1];
    }

    public static String getWinnerDetail(String string){
        String[] arr = string.split("\\s+");
        if (!arr[0].equals("winner")) return null;
        if (arr.length <= 2) return null;
        if (arr[2].equals("fold")) return "fold";
        String cardString = "";
        for(int i = 2;i < 7;i++){
            cardString += new Card(Integer.parseInt(arr[i])).toString() + " ";
        }
        return cardString;
    }
}
