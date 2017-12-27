package com.company.DZPK.controller;
/**
 * 牌
 */
public class Card {
    private int id;//牌的唯一编号
    private int num;//牌的点数
    private int color;//牌的花色 1:黑桃 2:红桃 3:草花 4:方片

    public Card(int id){
        this.id = id;
        this.num = id % 13 + 1;
        this.color = id / 13 + 1;
    }

    public Card(int id,int num,int color){
        this.id = id;
        this.num = num;
        this.color = color;
    }

    public Card(int num,int color){
        this.num = num;
        this.color = color;
        this.id = (num - 1) + (color - 1) * 13;
    }

    public int getId(){
        return this.id;
    }
    public int getNum(){
        return this.num;
    }
    public int getColor(){
        return this.color;
    }

    static public Card getCardFromId(int id){
        return new Card(id);
    }
}
