package com.company.DZPK.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/2.
 */
public class Compare {
    public Card[][] playercard=new Card[6][7];//玩家手牌+底牌
    public Card[][] playernuts=new Card[6][5];//玩家最佳牌型
    public Calculate[] nuts_1=new Calculate[6];//玩家最佳牌型选项1
    public Calculate_1[] nuts_2=new Calculate_1[6];//玩家最佳牌型选项2
    public int[] player_nuts_id=new int[6];//玩家最佳牌型编号
    public int nuts_num=0;//赢家牌型编号
    public int winner_num=1;//赢家数量
    public List<Integer> winner_id = new ArrayList<Integer>();//赢家编号
    public static void main(String[] args)
    {
        int n;

        return;
    }
    public Compare(int n, List<Player> players, List<Card> board)/*目前是假设传入n个player,还有桌面上的5张牌*/
    {
        for (int i = 0; i < n; i++)/*初始化了所有玩家的七张牌*/
        {
            Card[] hand = players.get(i).getHand();
            for (int j = 0; j < 2; j++)
            {
                playercard[i][j] = hand[j];
            }
            for (int j = 2; j < 7; j++)
            {
                playercard[i][j] = board.get(j - 2);
            }
        }
        for(int i = 0;i < n;i++)/*1和14两种情况取最佳放入nuts*/
        {
            nuts_1[i] = new Calculate(playercard[i]);
            nuts_2[i] = new Calculate_1(playercard[i]);
            if(cmp(nuts_1[i].nuts,nuts_2[i].nuts,nuts_1[i].nuts_id,nuts_2[i].nuts_id)>0)
            {
                player_nuts_id[i]=nuts_1[i].nuts_id;
                for(int j = 0;j < 5;j++)
                {
                    playernuts[i][j] = nuts_1[i].nuts[j];
                }
            }
            else
            {
                player_nuts_id[i] = nuts_2[i].nuts_id;
                for(int j = 0;j < 5;j++)
                {
                    playernuts[i][j]=nuts_2[i].nuts[j];
                }
            }
        }
    }
    public int cmp(Card[] a,Card[] b,int num_a,int num_b)/*a>b==1,a==b==2,a<b==0*/
    {
        if(num_a < num_b)
            return 0;
        else if (num_a > num_b)
            return 1;
        if(num_a > nuts_num)nuts_num = num_a;
        if(num_b > nuts_num)nuts_num = num_b;
        for(int i = 0;i < 5;i++)
        {
            if(a[i].getNum() > b[i].getNum())
                return 1;
            if(a[i].getNum() < b[i].getNum())
                return 0;
        }
        return 2;
    }
    public void get_winner(int n)
    {
        int winner_tmp = 0;
        for(int i = 1;i < n;i++)
        {
            winner_id.add(0);
            int ttt = cmp(playernuts[winner_tmp],playernuts[i],player_nuts_id[winner_tmp],player_nuts_id[i]);
            if(ttt == 0)
            {
                if(winner_num > 1) {
                    winner_num = 1;
                    winner_id.clear();
                }
                winner_tmp = i;
                winner_id.add(i);
            }
            else if(ttt == 2)
            {
                winner_num++;
                winner_id.add(i);
            }
        }
    }
 }
