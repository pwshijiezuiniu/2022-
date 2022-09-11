package com.pwalgo.interfaces;

import java.util.Scanner;

public class 字符串加解密 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.next();
        String enCode = scanner.next();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if(Character.isDigit(c)){
                if(c == '9'){
                    stringBuilder.append('0');
                }else {
                    stringBuilder.append((char) (c+1));
                }
            } else if (Character.isUpperCase(c)) {
                if(c == 'Z'){
                    stringBuilder.append('a');
                }else {
                    stringBuilder.append(Character.toLowerCase((char) (c+1)));
                }
            } else if (Character.isLowerCase(c)) {
                if(c == 'z'){
                    stringBuilder.append('A');
                }else {
                    stringBuilder.append(Character.toUpperCase((char) (c+1)));
                }
            }else {
                    stringBuilder.append(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < enCode.length(); i++) {
            char c = enCode.charAt(i);
            if(Character.isDigit(c)){
                if(c == '0'){
                    sb.append('9');
                }else {
                    sb.append((char) (c-1));
                }
            } else if (Character.isUpperCase(c)) {
                if(c == 'A'){
                    sb.append('z');
                }else {
                    sb.append(Character.toLowerCase((char) (c-1)));
                }
            } else if (Character.isLowerCase(c)) {
                if(c == 'a'){
                    sb.append('Z');
                }else {
                    sb.append(Character.toUpperCase((char) (c-1)));
                }
            }else {
                sb.append(c);
            }
        }
        System.out.println(stringBuilder.toString());

        System.out.println(sb.toString());
    }
}
