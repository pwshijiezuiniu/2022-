package com.pwalgo.interfaces;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 购物单 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int len = scanner.nextInt();
        int  [] prices = new int[len];
        int  [] meet = new int[len];
        int  [] isRoot = new int[len];

        for (int i = 0; i < len; i++) {
            prices[i] = scanner.nextInt();
            meet[i] = scanner.nextInt();
            isRoot[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(money);
        System.out.println(Arrays.toString(prices));
        System.out.println(Arrays.toString(meet));
        System.out.println(Arrays.toString(isRoot));
        PriorityQueue<int []> queue = new PriorityQueue<>((a,b)->{
            if(b[1]== a[1]){
                return a[0] - b[0];
            }
            return b[1] -a[1];
        });
        for (int i = 0; i < len; i++) {
            if(isRoot[i] == 0){
                queue.add(new int[]{prices[i],prices[i]*meet[i],i});
            }else{
                queue.add(new int[]{prices[i]+prices[isRoot[i]-1],i});
            }
        }





    }

}
