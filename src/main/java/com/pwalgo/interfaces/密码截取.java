package com.pwalgo.interfaces;

import java.util.Arrays;
import java.util.Scanner;

public class 密码截取 {
    //手撸最长回文子串
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.next();
        char helper[] = new char[source.length()*2 + 1];
        for (int i = 0; i < helper.length; i++) {
            if((i&1) == 1){
                helper[i] = source.charAt(i>>1);
            }else {
                helper[i] = '*';
            }
        }
        int r[] = new int[helper.length];
        int point = 0;
        int RB = 0;
        int candidate = 0;
        for (int i = 0; i < helper.length; i++) {
            if(i >= RB){
                int left = i,right = i;
                while(left >=0 && right < helper.length &&helper[left] == helper[right]){
                    left--;
                    right++;
                }
                point = i;
                RB = right-1;
                r[i] = RB-i;

            }else {

                if(2*point - i -r[2*point - i] > point - r[point]){
                    r[i] = r[2*point - i];
                } else if (2*point - i -r[2*point - i] < point - r[point]) {
                    r[i] = RB - i;
                }else {
                    int left = 2*i - RB-1,right = RB+1;
                    while(left >=0 && right < helper.length &&helper[left] == helper[right]){
                        left--;
                        right++;
                    }
                    point = i;
                    RB = right-1;
                    r[i] = RB-i;
                }
            }
            if(r[i] > r[candidate]){
                candidate = i;
            }
        }
        int count = 0;
        for (int i = candidate - r[candidate]; i <=candidate + r[candidate] ; i++) {
            if((i&1) == 1){
                count++;
            }
        }
        System.out.println(count);

    }
}
