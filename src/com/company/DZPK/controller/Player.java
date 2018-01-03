package com.company.DZPK.controller;

import com.company.DZPK.controller.Card;

/**
 * Created by Shanzhai on 2017/9/13.
 */
public class Player {
    private Card[] hand = new Card[2];
    private String nickname;
    private int id;
    private int playerId;
    private int money;
    private int status;//当前状态 0:未开始 1:弃牌 2:看牌或跟加注 3:Allin

    public Player(int id,int playerId,String nickname){
        this.nickname = nickname;
        this.id = id;
        this.playerId = playerId;
        this.money = 200000;
        this.status = 0;
    }

    public Card[] getHand(){
        return  this.hand;
    }
    public int getMoney(){
        return this.money;
    }
    public int getStatus(){
        return this.status;
    }
    public int getId(){
        return this.id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public void setHand(Card[] card){
        this.hand = card;
    }
    public void setHand(int place,Card card){
        hand[place] = card;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public void setStatus(int status){
        this.status = status;
    }

    public boolean changeMoney_jz(int cm){
        if (this.money - cm < 0) return false;
        this.money -= cm;
        return true;
    }//加注
    public boolean changeMoney_win(int cm){
        this.money += cm;
        return true;
    }//胜利
    public boolean changeStatus(int status,int money){
        if (status == 1){
            this.status = 1;
            return true;
        }
        if (status == 2){
            if (this.money < money) return false;
            else{
                changeMoney_jz(money);
                this.status = 2;
            }
            return true;
        }
        if (status == 3){
            if (this.money < money) return false;
            else{
                changeMoney_jz(money);
                this.status = 3;
            }
            return true;
        }
        return true;
    }

    public void init(int money){
        this.hand = new Card[2];
        this.money = money;
        this.status = 0;
    }
}
