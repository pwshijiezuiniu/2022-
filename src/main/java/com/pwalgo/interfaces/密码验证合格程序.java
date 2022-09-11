package com.pwalgo.interfaces;

import java.util.Scanner;
import java.util.regex.Pattern;

public class 密码验证合格程序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            if(str.length() < 9){
                System.out.println("NG");
            } else if (lowThanThree(str)) {
                System.out.println("NG");
            } else if (hasSubString(str,0,3)) {
                System.out.println("NG");
            }else {
                System.out.println("OK");
            }

        }
    }
    public static boolean hasSubString(String str,int left,int right){
        if(right == str.length()){
            return false;
        }
        if(str.substring(right).contains(str.substring(left,right))){
            return true;
        }else {
            return  hasSubString(str,left+1,right+1);
        }
    }
    public static boolean lowThanThree(String str){
        int count = 0;
        Pattern p1 = Pattern.compile("[0-9]");
        Pattern p2 = Pattern.compile("[a-z]");
        Pattern p3 = Pattern.compile("[A-Z]");
        Pattern p4 = Pattern.compile("[^0-9a-zA-Z]");
        if(p1.matcher(str).find()){
            count++;
        }
        if(p2.matcher(str).find()){
            count++;
        }
        if(p3.matcher(str).find()){
            count++;
        }
        if(p4.matcher(str).find()){
            count++;
        }
        return count < 3;
    }

}
