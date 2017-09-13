package DZPK;

/**
 * Created by Shanzhai on 2017/9/13.
 */
public class Player {
    private Card[] hand = new Card[2];
    private int money;


    public Card[] getHand(){
        return  this.hand;
    }
    public int getMoney(){
        return this.money;
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

    public boolean changeMoney(int add){
        if (money + add < 0) return false;
        money += add;
        return true;
    }
}
