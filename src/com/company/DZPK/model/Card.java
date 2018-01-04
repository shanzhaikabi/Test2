package com.company.DZPK.model;
/**
 * 牌
 */
public class Card {
    private int id;//牌的唯一编号
    private int num;//牌的点数
    private int color;//牌的花色 1:黑桃 2:红桃 3:草花 4:方片

    public String[] colorToString = {"","\u9ed1\u6843","\u7ea2\u6843","\u8349\u82b1","\u65b9\u7247"};
    public String[] numToString = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    public String getColorS(){
        return colorToString[color];
    }

    public String getNumS(){
        return numToString[num];
    }

    public Card(int id){
        this.id = id;
        this.num = id % 13 + 1;
        this.color = id / 13 + 1;
    }

    public String toString(){
        return this.getColorS() + this.getNumS();
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
    public void change(){if(this.num==1)this.num=14;}

    static public Card getCardFromId(int id){
        return new Card(id);
    }
    //TODO:展示课GIT练习操作
}
