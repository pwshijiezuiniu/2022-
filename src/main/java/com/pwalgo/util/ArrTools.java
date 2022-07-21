package com.pwalgo.util;

import java.util.HashMap;

public class ArrTools {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String a = new String("sb");
        String b= new String("sb");
        System.out.println(a==b);
        map.put(a,"1");
        map.put(b,"2");
        System.out.println(map.size());
    }
    public static int [] getRandomArr(int maxSize,int maxVal){
        int [] arr = new int [(int) (Math.random()*(maxSize+1))];
        //Arrays.stream(arr).peek()
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*(maxVal+1)) - (int) (Math.random()*(maxVal+1));
        }
        return arr;
    }
}
