package com.pwalgo.classicalgorithms;

import java.util.Arrays;
import java.util.HashMap;

public class KMP {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int a = 1;
        Integer integer = 1;
        Integer integer1 = new Integer(1);
        System.out.println(System.identityHashCode(integer1));
        System.out.println(System.identityHashCode(integer));
//        System.out.println(integer.toString());
//        System.out.println(integer1);

    }


    public static int kmp(String str1,String str2){
        if(str2.length() > str1.length()){
            return -1;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int [] next = getNext(char2);
        int l1 = 0,l2 = 0;
        while (l1 < char1.length && l2 < char2.length){
            if(char1[l1] == char2[l2]){
                l1++;
                l2++;
            } else if (l2 > 0) {
                l2 = next[l2];
            }else {
                l1++;
            }
        }
        return l2 == char2.length ? l1 - l2 : -1;
    }
    public static int[] getNext(char [] str){
        if(str.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cur = 0;
        while(i < str.length){
            if(str[i-1] == str[cur]){
                next[i++] = ++cur;
            } else if (cur > 0) {
                cur = next[cur];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
