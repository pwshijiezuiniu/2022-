package com.pwalgo.interfaces;

import java.util.Scanner;

public class 字符串排序 {
    public static void main(String[] args) {

        //A Famous Saying: Much Ado About Nothing (2012/8).
        //A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        StringBuilder [] bucket = new StringBuilder[26];
        for(int i = 0;i < chars.length;i++){
            if(Character.isAlphabetic(chars[i])){
                int sort = Character.toLowerCase(chars[i])-'a';
                if(bucket[sort] == null){
                    bucket[sort] = new StringBuilder();
                }
                bucket[sort].append(chars[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;

        for (StringBuilder builder : bucket) {
            if(builder == null){
                continue;
            }else {
                int len = builder.length();
                for (int j = 0; j < len; j++) {
                    while(i < chars.length && !Character.isAlphabetic(chars[i])){
                        stringBuilder.append(chars[i]);
                        i++;
                    }
                    stringBuilder.append(builder.charAt(j));
                    i++;
                }
            }
        }
        while(i < chars.length && !Character.isAlphabetic(chars[i])){
            stringBuilder.append(chars[i]);
            i++;
        }

        System.out.println(stringBuilder.toString());

    }
}
