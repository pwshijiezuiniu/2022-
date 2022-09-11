package com.pwalgo.advance.class01;

public class Code04_SameStragithLine {
    public static void main(String[] args) {
        System.out.println(gcd(10,6));
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

}
