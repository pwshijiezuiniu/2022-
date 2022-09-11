package com.pwalgo.base.class01;

import com.pwalgo.base.util.ArrTools;

import java.util.Arrays;

public class Code04_BSExist {
    public static void main(String[] args) {
        boolean flag =true;
        for (int i = 0; i < 5000; i++) {
            int val = (int) (Math.random()*(11));
            int [] arr = ArrTools.getRandomArr(100,100);
            Arrays.sort(arr);
            if(!(bsExist(arr, val)&&test(arr,val) || test(arr,val)==false&&bsExist(arr, val)==false)){
                printArr(arr);
                System.out.println("key:"+val);
                System.out.println(bsExist(arr, val)+":"+test(arr,val));
                flag = false;
                break;
            }
        }
        System.out.println(flag?"yes":"fucking");

    }
    public static boolean bsExist(int [] arr,int val){
        if (arr==null || arr.length==0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while(left < right){
            mid = left + ((right - left) >> 1);
            if(arr[mid] > val){
               right = right -1;
            } else if (arr[mid] < val) {
                left = left + 1;
            }else {
                return true;
            }
        }
        return val == arr[right];
    }
    public static boolean test(int [] arr,int val){
        return Arrays.stream(arr).filter(a->a==val).count() > 0;

    }
    public static void printArr(int [] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
}
