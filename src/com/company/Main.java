package com.company;
import DZPK.Calculate;
import DZPK.frame.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long T = s.nextLong();
        BigDecimal x1,y1,x2,y2,x3,y3,x,y;
        while((T--) > 0) {
            x1 = s.nextBigDecimal();
            y1 = s.nextBigDecimal();
            x2 = s.nextBigDecimal();
            y2 = s.nextBigDecimal();
            x3 = s.nextBigDecimal();
            y3 = s.nextBigDecimal();
            x = s.nextBigDecimal();
            y = s.nextBigDecimal();
            BigDecimal A1, A2, B1, B2, C1, C2, temp,ox,oy,r,dis;
            A1 = x1.subtract(x2);
            B1 = y1.subtract(y2);
            BigDecimal t1 = x1.multiply(x1),t2 = x2.multiply(x2),t3 = y1.multiply(y1),t4 = y2.multiply(y2);
            C1 = (((t1.add(t3)).subtract(t2)).subtract(t4)).divide(new BigDecimal(2));
            A2 = x3.subtract(x2);
            B2 = y3.subtract(y2);
            BigDecimal t5 = x3.multiply(x3),t6 = y3.multiply(y3);
            C2 = (((t5.add(t6)).subtract(t2)).subtract(t4)).divide(new BigDecimal(2));
            //为了方便编写程序，令temp = A1*B2 - A2*B1
            temp = A1.multiply(B2).subtract(A2.multiply(B1));
            //判断三点是否共线
            if (temp.doubleValue() == 0){
                //共线则将第一个点pt1作为圆心
                ox = x1;
                oy = y1;
            }
            else{
                //不共线则求出圆心：
                //center.x = (C1*B2 - C2*B1) / A1*B2 - A2*B1;
                //center.y = (A1*C2 - A2*C1) / A1*B2 - A2*B1;
                ox = (C1.multiply(B2).subtract(C2.multiply(B1))).divide(temp);
                oy = (A1.multiply(C2).subtract(A2.multiply(C1))).divide(temp);
            }
            r = (ox.subtract(x1).multiply(ox.subtract(x1))).add((oy.subtract(y1)).multiply(oy.subtract(y1)));
            dis = (ox.subtract(x).multiply(ox.subtract(x))).add((oy.subtract(y)).multiply(oy.subtract(y)));
            if (dis.compareTo(r) == 1) System.out.println("Accepted");
            else System.out.println("Rejected");
        }
    }
}

/* BigDecimal A1, A2, B1, B2, C1, C2, temp,ox,oy,r;
            A1 = new BigDecimal(x1 - y1);
            B1 = new BigDecimal(y1 - y2);
            C1 = new BigDecimal((pow(x1, 2) - pow(x2, 2) + pow(y1, 2) - pow(y2, 2)) / 2);
            A2 = new BigDecimal(x3 - x2);
            B2 = new BigDecimal(y3 - y2);
            C2 = new BigDecimal((pow(x3, 2) - pow(x2, 2) + pow(y3, 2) - pow(y2, 2)) / 2);
            //为了方便编写程序，令temp = A1*B2 - A2*B1
            temp = A1.multiply(B2).subtract(A2.multiply(B1));
            //判断三点是否共线
            if (temp.doubleValue() == 0){
                //共线则将第一个点pt1作为圆心
                ox = new BigDecimal(x1);
                oy = new BigDecimal(y1);
            }
            else{
                //不共线则求出圆心：
                //center.x = (C1*B2 - C2*B1) / A1*B2 - A2*B1;
                //center.y = (A1*C2 - A2*C1) / A1*B2 - A2*B1;
                ox = (C1.multiply(B2).subtract(C2.multiply(B1))).divide(temp);
                ox = (A1.multiply(C2).subtract(A2.multiply(C1))).divide(temp);
            }

            r = sqrtf((CD.center.x - x1)*(CD.center.x - x1) + (CD.center.y - y1)*(CD.center.y - y1));
        */