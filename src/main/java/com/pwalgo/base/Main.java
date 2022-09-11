package com.pwalgo.base;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        char [] arr = new char[]{'b','b','a','b'};
        System.out.println(test(arr));
    }
    public static String test(char [] str){
        int N = str.length;
        String [][] dp = new String [N][N];
        for(int i=0;i <N;i++){
            dp[i][i] = str[i]+"";
        }
        for(int identity = 1;identity < N;identity++){
            for(int index = 0;index < N - identity;index++){

                dp[index][index+identity] = dp[index][index+identity-1].length() >= dp[index+1][index+identity].length() ? dp[index][index+identity-1]:dp[index+1][index+identity];
                if(str[index] == str[index+identity] && (dp[index+1][index+identity-1]==null || dp[index+1][index+identity-1].length() == identity-1)){
                    dp[index][index+identity] =  String.valueOf(str,index,identity+1);
                }
            }
        }

        return dp[0][N-1];
    }
    public static void reverseStack(Stack<Integer> stack){
        for(int i = 1;i < stack.size();i++){
            reverseStack(stack,stack.pop(),i);
        }
    }
    public static void reverseStack(Stack<Integer> stack,int value,int index){
       if(stack.size() == index){
           int cur = stack.pop();
           stack.push(value);
           stack.push(cur);
           return;
       }

       int temp = stack.pop();
        System.out.println("temp="+temp);
       reverseStack(stack,value,index);
       stack.push(temp);
    }
}