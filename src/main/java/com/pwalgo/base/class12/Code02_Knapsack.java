package com.pwalgo.base.class12;

public class Code02_Knapsack {
    public static void main(String[] args) {
//        int [] weight = new int[]{3,5,8,1,9,2};
//        int [] values = new int[]{7,2,8,3,2,5};
//        int bag = 15;
//        System.out.println(start(weight,values,bag));
//        System.out.println(getMaxValuesByDP(weight,values,bag));
        int n = 45;
        System.out.println(fByDp(n));
        System.out.println(f(n));
    }
    //从index往后最多能得到多少价值 重量不超过rest
    public static int start(int [] weight,int [] values,int bag){
        return getMaxValuse(weight,values,0,bag);
    }
    public static int getMaxValuse(int [] weight,int [] values,int index,int rest){
        if(rest < 0){
            return -1;
        }
        if(index == weight.length){
            return 0;
        }
        int selectA = getMaxValuse(weight,values,index+1,rest);
        int selectB = 0;
        int next = getMaxValuse(weight,values,index+1,rest-weight[index]);
        if(next != -1){
            selectB = values[index] + next;
        }
        return Math.max(selectA,selectB);
    }
    public static int getMaxValuesByDP(int [] weight,int [] values,int bag){
        int N = weight.length;
        int nowWeight = 0;
        int [][] dp = new int[N+1][bag+1];
        for (int index = N-1; index >=0 ; index--) {
            for (int rest = 1; rest <= bag; rest++) {
                dp[index][rest] = dp[index+1][rest];
                if(weight[index] <= rest){
                    dp[index][rest] = Math.max(dp[index][rest],values[index] + dp[index][rest-weight[index]]);
                }
            }
        }
        return dp[0][bag];
    }
    public static int f(int n){
        if(n < 3){
            return 1;
        }
        return f(n-1)+f(n-2);
    }
    public static int fByDp(int n){
        if(n<3){
            return 1;
        }
        int [] dp = new int[n+1];
        dp[1] = 1;dp[2] =1;
        for (int index = 3; index <= n; index++) {
            dp[index] = dp[index-1] +dp[index-2];
        }
        return dp[n];
    }
}
