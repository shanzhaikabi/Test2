package com.company.DZPK.model;

import com.company.DZPK.model.Card;
import com.company.DZPK.model.Player;

/**
 * Created by Shanzhai on 2017/9/14.
 */
public class Table {
    private Player player[];
    private Card cards[];
    private int totalMoney;
    private int maxMoneyOfPlayers;//最高加注上限
    private int maxMoneyPlayerPlace;//最多钱的玩家
    private int currentPlayerPlace;//当前玩家
    private int currentMoneyOnTable;//当前加注金额
    private int minMoneyOnTable;//最小加注金额(大盲注)

    public int getMinMoneyOnTable(){
        return this.minMoneyOnTable;
    }

    public void setMinMoneyOnTable(int money){
        this.minMoneyOnTable = money;
    }
}
