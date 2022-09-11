package com.pwalgo.advance.class04;

public class Code01_TimesToNBySAndM {
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println(timesToNBySAndM(i));
        }
    }
    public static int timesToNBySAndM(int n){
        return process(1,1,n,0);
    }
    public static int process(int s,int m,int N,int times){
        if(s == N){
            return times;
        }
        if(s > N){
            return Integer.MAX_VALUE;
        }
        int less = process(2*s,s,N,times+1);
        less = Math.min(less,process(s+m,m,N,times+1));
        return less;
    }

}
