package DZPK;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/9/13.
 */
public class Calculate{
    private Card[] ans= new Card[7];//底牌两张和场上五张牌
    public Card getcard(int x){return ans[x-1];}//返回第x张牌
    public boolean tonghua()//判定同花
    {
        int[] color ={0,0,0,0,0};
        for(int i=0;i<7;i++)//统计各花色个数
        {
            color[ans[i].getColor()]++;
        }
        for(int i=1;i<5;i++)//同花色超过5张返回正确
        {
            if(color[i]>=5)return true;
        }
        return false;
    }
    public boolean tonghuashun()//判定同花顺
    {
        int[] color ={0,0,0,0,0};
        for(int i=0;i<7;i++)//统计花色
        {
            color[ans[i].getColor()]++;
        }
        int f=0,l=0;//f为同花的花色，l是同花色的个数
        for(int i=1;i<5;i++)
        {
            if(color[i]>=5){f=i;l=color[i];}
        }
        if(f==0)return false;//不是同花直接退出
        int cnt=0;//临时变量，储存存了几个同花的牌的点数
        int[] a={0,0,0,0,0,0,0};//存储点数，之后排序找同花顺
        for(int i=0;i<7;i++)
        {
            if(color[ans[i].getColor()]==f)a[cnt++]=ans[i].getNum();
        }
        Arrays.sort(a,0,l);//对该花色的点数排序
        for(int i=0;i<=l-5;i++)//找顺子
        {
            if(a[i]==a[i+1]-1&&a[i]==a[i+1]-2&&a[i]==a[i+3]-3&&a[i]==a[i+4]-4)
                return true;
        }
        return false;
    }
    public boolean shunzi()//判定顺子
    {
        int[] a={0,0,0,0,0,0,0};//记录七张牌点数
        for(int i=0;i<7;i++)
            a[i]=ans[i].getNum();
        Arrays.sort(a);//排序后找连续五张
        for(int i=0;i<3;i++)
        {
            if(a[i]==a[i+1]-1&&a[i]==a[i+1]-2&&a[i]==a[i+3]-3&&a[i]==a[i+4]-4)
                return true;
        }
        return false;
    }
    public int duizi()//当前葫芦1，三条2，两对3，一对4，五烂0
    {
        int[] n={0,0,0,0,0,0,0,0,0,0,0,0,0,0}//记录各点数牌数
        for(int i=0;i<7;i++)
            n[ans[i].getNum()]++;
        int two=0,three=0;//记录对子和三条个数
        for(int i=1;i<14;i++)
        {
            if(n[i]==2)two++;
            else if (n[i]==3)three++;
        }
        if(three==1)
        {
            if(two>0)return 1;
            return 2;
        }
        if(two>0)
        {
            if(two>1)return 3;
            return 4;
        }
        return 0;
    }
}
