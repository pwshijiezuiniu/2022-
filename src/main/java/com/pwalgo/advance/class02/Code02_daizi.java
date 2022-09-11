package com.pwalgo.advance.class02;

public class Code02_daizi {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            if(canDown(i) != canDn(i)){
//                System.out.println("不对");
//                break;
//            }
            System.out.println(i+","+canDn(i));
        }
        System.out.println(canDn(26));
    }
    public static boolean canDown(int x){
        if(x < 12){
            return x==6 || x==8;
        }
        return (x&1) == 0;
    }
    public static int canDn(int x){
        if(x < 6){
            return -1;
        }
        int q = x / 8;
        for (int i = q; i >=0;i--){
            if(x - i*8 > 24){
                break;
            }

            if((x-8*i)%6 == 0){
                return i+(x-8*i)/6 ;
            }

        }
        return  -1;
    }
}
