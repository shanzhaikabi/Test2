package com.company.DZPK.controller;

import java.util.Arrays;
import java.util.Scanner;
/*这里所有的A都当做一来算*/
/**
 * Created by Administrator on 2017/9/13.
 */
public class Calculate{
    final String[] hs = {"","黑桃","红桃","草花","方片"};
    private Card[] ans= new Card[7];//底牌两张和场上五张牌
    public Card getcard(int x){return ans[x-1];}//返回第x张牌
    public Card[] nuts=new Card[5];
    public int nuts_id=0;
    public void getans(){
        System.out.println("请输入牌型");
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < 7;++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ans[i] = new Card(a, b);//num，color
        }
        return;
    }
    public Card search_num(int num)
    {
        for(int i=0;i<7;i++)
        {
            if(ans[i].getNum()==num)
            {
                return ans[i];
            }
        }
        return new Card(1,1);
    }
    public void test(){
        int p = getPX();
        if (p == 77){System.out.println("同花顺");nuts_id=8;}
        if (p == 5) {System.out.println("四条");nuts_id=7;}
        if (p == 66) {System.out.println("同花");nuts_id=6;}
        if (p == 55){System.out.println("顺子");nuts_id=5;}
        if (p == 1) {System.out.println("葫芦");nuts_id=4;}
        if (p == 2) {System.out.println("三条");nuts_id=3;}
        if (p == 3) {System.out.println("两对");nuts_id=2;}
        if (p == 4) {System.out.println("一对");nuts_id=1;}
        if (p == 0) {System.out.println("高牌");nuts_id=0;}
        /*for(int i = 0;i < 7;++i){
            System.out.print(hs[ans[i].getColor()] + ans[i].getNum() + ' ');
        }
        System.out.println();*/
    }
    public int getPX(){
        if (tonghuashun()) return 77;
        int p = duizi();
        if (p == 1) return 1;
        if (p == 5) return 5;
        if (tonghua()) return 66;
        if (shunzi()) return 55;
        return p;
    }
    public boolean tonghua()//判定同花
    {
        int[] color ={0,0,0,0,0};
        for(int i=0;i<7;i++)//统计各花色个数
        {
            color[ans[i].getColor()]++;
        }
        for(int i=1;i<5;i++)//同花色超过5张返回正确
        {
            if(color[i]>=5)
            {
                int t[]=new int[7];
                int cnt=0;
                for(int j=0;j<7;j++)
                {
                   if(ans[j].getColor()==i)
                   {
                       t[cnt++]=ans[j].getNum();
                   }
                }
                Arrays.sort(t,0,cnt);
                for(int h=0;h<5;h++)
                {
                    nuts[h]=new Card(t[cnt-h-1],i);
                }
                return true;
            }
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
            if(ans[i].getColor()==f)a[cnt++]=ans[i].getNum();
        }
        Arrays.sort(a,0,l);//对该花色的点数排序
        for(int i=0;i<=l-5;i++)//找顺子
        {
            if(a[i]==a[i+1]-1&&a[i]==a[i+2]-2&&a[i]==a[i+3]-3&&a[i]==a[i+4]-4)
            {
                for(int j=4;j>=0;j++)
                {
                    nuts[j]=new Card(a[i+4-j],f);
                }
                return true;
            }
        }
        return false;
    }
    public boolean shunzi()//判定顺子
    {
        int[] a={0,0,0,0,0,0,0};//记录七张牌点数
        int[] vis={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int tmp=0;
        for(int i=0;i<7;i++)
        {
            if(vis[ans[i].getNum()]==1)continue;
            vis[ans[i].getNum()]=1;
            a[tmp++] = ans[i].getNum();
        }
        Arrays.sort(a);//排序后找连续五张
        for(int i=0;i<=2;i++)
        {
            if(a[i]!=0&&a[i]==a[i+1]-1&&a[i]==a[i+2]-2&&a[i]==a[i+3]-3&&a[i]==a[i+4]-4)
            {
                for(int j=0;j<5;j++)
                {
                    nuts[j]=search_num(a[i+j]);
                }
                return true;
            }
        }
        return false;
    }
    public int duizi()//当前葫芦1，三条2，两对3，一对4，五烂0
    {
        int[] n={0,0,0,0,0,0,0,0,0,0,0,0,0,0};//记录各点数牌数
        for(int i = 0;i < 7;i++)
            n[ans[i].getNum()]++;
        int two=0,three=0,four=0;//记录对子和三条个数
        for(int i=1;i<14;i++)
        {
            if(n[i]==2)two++;
            else if (n[i]==3)three++;
            else if (n[i]==4)four++;
        }
        if(four == 1)
        {
            int kk=0;
            for(int i=1;i<14;i++)
            {
                if(n[i]==4)
                {
                    for(int j=0;i<4;j++)
                    {
                        nuts[j]=new Card(i,j+1);
                    }
                    break;
                }
            }
            for(int i=13;i>0;i--)
            {
                if(n[i]<=3&&n[i]>=1)
                {
                    for(int j=0;j<7;j++)
                    {
                        if(ans[j].getNum()==i)
                        {
                          nuts[4]=ans[j];
                          break;
                        }
                    }
                    break;
                }
            }
            return 5;
        }
        if(three==2||(three==1&&two>=1))
        {
            int san=0,er=0;
            for(int i=13;i>=1;i--)
            {
                if(n[i]==3)
                {
                    san=i;
                    break;
                }
            }
            for(int i=13;i>=1;i--)
            {
                if(n[i]>=2&&n[i]!=san)
                {
                    er=i;
                    break;
                }
            }
            int cnt=0;
            for(int i=0;i<=7;i++)
            {
                if(ans[i].getNum()==san)
                {
                    nuts[cnt++]=ans[i];
                }
            }
            for(int i=0;i<=7;i++)
            {
                if(ans[i].getNum()==er&&cnt<5)
                {
                    nuts[cnt++]=ans[i];
                }
            }
            return 1;
        }
        if(three==1&&two==0)
        {
            int san=0,yi=0,er=0;
            for(int i=13;i>0;i--)
            {
                if(n[i]==3)
                {
                    san=i;
                    break;
                }
            }
            for(int i=13;i>=0;i--)
            {
                if(n[i]>0&&n[i]!=san)
                {
                    yi=i;
                    break;
                }
            }
            for(int i=13;i>=1;i--)
            {
                if(n[i]>0&&n[i]!=san&&n[i]!=yi)
                {
                    er=i;
                    break;
                }
            }
            int cnt=0;
            for(int i=0;i<=7;i++)
            {
                if(ans[i].getNum()==san)
                {
                    nuts[cnt++]=ans[i];
                }
            }
            for(int i=0;i<=7;i++)
            {
                if(ans[i].getNum()==yi)
                {
                    nuts[cnt++]=ans[i];
                }
                if(ans[i].getNum()==er)
                {
                    nuts[cnt++]=ans[i];
                }
            }
            return 2;
        }
        if(two>=2)
        {
            int aaa=0,bbb=0,ccc=0;
            for(int i=13;i>=1;i--)
            {
                if(n[i]>=2&&aaa==0)
                    aaa=i;
                else if(n[i]>=2&&aaa!=0&&bbb==0)
                    bbb=i;
                else if(n[i]>0&&ccc==0)
                    ccc=i;
            }
            int cnt=0;
            for(int i=0;i<=7;i++)
            {
                if(ans[i].getNum()==aaa)
                {
                    nuts[cnt++]=ans[i];
                }
            }
            for(int i=0;i<=7;i++)
            {
                if(ans[i].getNum()==bbb)
                {
                    nuts[cnt++]=ans[i];
                }
            }
            for(int i=0;i<=7;i++)
            {
                if(ans[i].getNum()==ccc)
                {
                    nuts[cnt++]=ans[i];
                }
            }
            return 3;
        }
        if(two==1)
        {
            int aaa=0,bbb=0,ccc=0,ddd=0;
            for(int i=13;i>=1;i--)
            {
                if(n[i]>=2&&aaa==0)
                    aaa=i;
                else if(n[i]>0&&bbb==0)
                    bbb=i;
                else if(n[i]>0&&ccc==0)
                    ccc=i;
                else if(n[i]>0&&ddd==0)
                    ddd=i;
            }
            int cnt=0;
            for(int i=0;i<=7;i++)
            {
                if(ans[i].getNum()==aaa)
                {
                    nuts[cnt++]=ans[i];
                }
            }
            nuts[cnt++]=search_num(bbb);
            nuts[cnt++]=search_num(ccc);
            nuts[cnt++]=search_num(ddd);
            return 4;
        }
        int[] a={0,0,0,0,0,0,0};//记录七张牌点数
        for(int i=0;i<7;i++)
        {
            a[i] = ans[i].getNum();
        }
        Arrays.sort(a);
        for(int i=6;i>1;i--)
        {
            nuts[6-i]=search_num(a[i]);
        }
        return 0;
        /*if(three==1)
        {
            if(two>0)return 1;
            return 2;
        }
        if(two>0)
        {
            if(two>1)return 3;
            return 4;
        }
        return 0;*/
    }
}
