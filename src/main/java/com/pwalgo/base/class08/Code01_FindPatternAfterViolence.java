package com.pwalgo.base.class08;

import java.util.HashMap;
import java.util.Map;

public class Code01_FindPatternAfterViolence {

    public static void main(String[] args) {
        //System.out.println(func1Plus(55));
        findPattern1();
    }

    //N是否能变成连续的正整数的和  数量要大于1
    public static boolean func1Plus(int n){
        if(n < 3) return false;
        return (n&(n-1)) != 0;
    }
    public static boolean func1(int n){
        if(n < 3){
            return false;
        }
        for (int i = 1; i <= n/2+1; i++) {
            int sum = 0;
            for (int j = i; j <= n/2+1; j++) {
                sum +=j;
                if(sum ==n) return true;
                if(sum > n) break;

            }
        }
        return false;
    }
    public static void findPattern1(){
        for (int i = 0; i < 100; i++) {
            System.out.println(i+":"+func1Plus(i));
        }
    }
}
