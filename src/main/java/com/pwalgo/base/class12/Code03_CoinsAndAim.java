package com.pwalgo.base.class12;

public class Code03_CoinsAndAim {
    public static void main(String[] args) {
        int [] arr = new int[]{5,10,50,100};
        int aim = 1000;
        System.out.println(getWays(arr,aim));
    }
    public static int getWays(int [] arr,int aim){
        if(arr == null || arr.length ==0 || aim < 0){
            return 0;
        } 
        int [][] dp = new int[arr.length+1][aim+1];
        dp[arr.length][0] = 1;
        for (int index = arr.length - 1; index >= 0 ; index--) {
            for (int rest = 0; rest <= aim ; rest++) {
                dp[index][rest] =  dp[index+1][rest];
                if(rest >= arr[index]){
                    dp[index][rest] +=dp[index][rest-arr[index]];
                }
            }
        }
        return dp[0][aim];
    }
}
