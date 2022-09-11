package com.pwalgo.advance.class02;

public class Code03_CowEatCao {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i+","+f(i));
        }
//        boolean c = 1==1;
       // System.out.println(f(2));
       //System.out.println(f(5) +","+ l(5));
    }
    public static boolean f(int x){
        if(x == 0){
            return false;
        }

        for (int i = 1; i <=x ; i*=4) {
            if(l(x-i)) return true;
            if(i > x/4){
                break;
            }
        }
        return false;
    }
    public static boolean l(int x){
        //System.out.println(x);
        //System.out.println(x);
        if(x == 0){
            return true;
        }
        for (int i = 1; i <=x ; i*=4) {
            if(!f(x-i)) return false;
            if(i > x/4){
                break;
            }
        }
        return true;
    }
}
