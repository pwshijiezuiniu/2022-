package com.pwalgo.interfaces;

import java.util.Scanner;

public class 丑数 {
    public static void main(String[] args) {
        //求出所有质因数


    }
    public  boolean func(int num){
        if(num == Integer.MIN_VALUE){
            return true;
        }
        num = Math.abs(num);
        int k = 2;
        while(k <= num){
            if(k == num){
                if(!isIn(k)){
                    return false;
                }else {
                    return true;
                }

            } else if (num%k == 0) {
                if(!isIn(k)){
                    return false;
                }
                num /= k;
            }else{
                k++;
            }
        }

        return true;
    }
    public  boolean isIn(int k){
        if(k==2 || k ==3 || k==5){
            return true;
        }
        return false;
    }

}
