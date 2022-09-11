package com.pwalgo.classicalgorithms;

import java.util.Arrays;

public class Manacher {

    public static void main(String[] args) {
        System.out.println(getMaxPalindromeLen("222020221"));
    }
    public static int getMaxPalindromeLen(String s){
        if(s == null || s.length() < 1) return -1;
        if(s.length() == 1){
            return 1;
        }

        //预处理字符数组
        char [] pStr = new char[(s.length() << 1) +1];
        for (int i = 0; i < pStr.length; i++) {
            if((i&1)==1){
                pStr[i] = s.charAt((i-1)>>1);
            }else {
                pStr[i] = '#';
            }
        }
        System.out.println(String.valueOf(pStr));
        int [] pLen = new int[pStr.length];
        int R = -1;
        int C = -1;
        for (int i = 0; i < pStr.length; i++) {
            if(i >= R){
                int left = i-1;
                int right = i+1;
             while(left >= 0 && right < pStr.length&&pStr[left] ==pStr[right]){
                 left--;
                 right++;
             }
             pLen[i] = right - left-1;
             R = right -1;
             C = i;
            }else if ((2*C - i - (pLen[(2*C - i)]>>1)) > (C - (pLen[C]>>1))){
                pLen[i]=pLen[2*C - i];
            }else if ((2*C - i - (pLen[(2*C - i)]>>1)) < (C - (pLen[C]>>1))) {
                pLen[i] = ((R-i)<<1) + 1;
            } else{
                int left = 2*i - R - 1;
                int right = R + 1;
                while(left >= 0 && right < pStr.length&&pStr[left] ==pStr[right]){
                    left--;
                    right++;
                }
                pLen[i] = right - left-1;
                if(right - 1 > R){
                    R = right -1;
                    C = i;
                }
            }
        }
        Arrays.stream(pLen).forEach(System.out::println);
        System.out.println("============");
        int max = 0;
        for (int i = 0; i <pStr.length; i++) {
            max = Math.max(pLen[i],max);
        }
        return max;

    }
}
