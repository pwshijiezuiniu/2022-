package com.pwalgo.base.test;

import javafx.util.Pair;
import org.junit.Test;


import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;



public class TestTest {
    @Test
    public void cc(){
        int n = 0;//接受
        int [] res = new int[2*n];
        int left = 0,right = n;
        for (int i = 0; i < n; i++) {

        }
    }




























    public int pro(int i,int m){
        if(i == 1){
            return  1;
        }
        return (pro(i-1,m)+m)%i;
    }
    public int LastRemaining_Solution2(int n, int m) {
        if(n == 0 || m == 0){
            return -1;
        }
        int index = 1;
        for(int i = 2 ; i <= n ; i++){
            index = (index + m) % i;
            if(index == 0){
                index += i;
            }
        }
        return index;
    }

    public long k(int i){
        if(i < 3){
            return i;
        }
        return (long) i * k(i-1);
    }
    public int getZero(long num){
        int ans = 0;
        while(num %10 == 0){
            ans++;
            num/=10;
        }
        return ans;
    }








}