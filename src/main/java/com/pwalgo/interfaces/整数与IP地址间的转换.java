package com.pwalgo.interfaces;

import java.util.Arrays;
import java.util.Scanner;

public class 整数与IP地址间的转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.next();
        Long num = scanner.nextLong();
        int [] base = new int[]{
                1<<24,1<<16,1<<8,1
        };
        String[] split = ip.split("\\.");
        int printNum = 0;
        for (int i = 0; i < 4; i++) {
            printNum +=Integer.parseInt(split[i]) * base[i];
        }
        StringBuilder printIp = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            printIp.append(num / base[i]);
            printIp.append(".");
            num %=base[i];
        }
        System.out.println(printNum);
        System.out.println(printIp.deleteCharAt(printIp.length()-1).toString());
    }
}
