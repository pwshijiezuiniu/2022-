package com.pwalgo.base.class12;

public class Code01_RobotWalk {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        int cur1 = way1(19,13,30,17);
        Long end1 = System.currentTimeMillis();
        System.out.println(cur1+",本次用了"+(end1 - start1)+"ms");
        long start = System.currentTimeMillis();
        int cur = way(19,13,30,17);
        Long end = System.currentTimeMillis();
        System.out.println(cur+",本次用了"+(end - start)+"ms");

    }
    public static int way(int N,int M,int K,int P){
        if(N<2 || M<1 || M>N || K<1 || P<1 || P>N){
            return 0;
        }
        return walk(N,M,K,P);
    }
    public static int walk(int N,int cur,int rest,int P){
        if(rest==0){
            return cur == P ? 1 : 0;
        }
        if(cur == 1){
            return walk(N,2,rest-1,P);
        }
        if(cur == N){
            return walk(N,N-2,rest-1,P);
        }
        return walk(N,cur-1,rest-1,P) + walk(N,cur +1,rest-1,P);
    }

    public static int way1(int N,int M,int K,int P){
        if(N<2 || M<1 || M>N || K<1 || P<1 || P>N){
            return 0;
        }
        int [][] dp = new int[N+1][K+1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return walk1(N,M,K,P,dp);
    }
    public static int walk1(int N,int cur,int rest,int P,int [][] dp){
        if(dp[cur][rest] != -1){
            return dp[cur][rest];
        }
        if(rest==0){
            dp[cur][rest] = cur == P ? 1 : 0;
            return dp[cur][rest];
        }
        if(cur == 1){
            dp[cur][rest] = walk1(N,2,rest-1,P,dp);
            return dp[cur][rest];
        }
        if(cur == N){
            dp[cur][rest] = walk1(N,N-2,rest-1,P,dp);
            return dp[cur][rest];
        }
        dp[cur][rest]= walk1(N,cur-1,rest-1,P,dp) + walk1(N,cur +1,rest-1,P,dp);
        return dp[cur][rest];
    }

}
