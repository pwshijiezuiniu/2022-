package com.pwalgo.class01;

import com.pwalgo.util.ArrTools;

import java.util.Arrays;

public class Code05_BSNearLeft {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 5000; i++) {
            int val = (int) (Math.random()*51);
            int [] arr = ArrTools.getRandomArr(500,500);
            Arrays.sort(arr);
            if (test(arr,val) != bsNearLeft(arr,val)) {
                printArr(arr);
                System.out.println("key::"+val+"bsNearLeft"+arr[bsNearLeft(arr,val)]+"test"+arr[test(arr,val)]);
                flag = false;
                break;
            }
        }
        System.out.println(flag?"yes":"fucking");
    }
    //找出>=val的最左边那个数
    public static int bsNearLeft(int [] arr,int val){
        if(arr==null || arr.length==0){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int index = -1;
        while(left <= right){
            mid = left + ((right - left)>>1);
            if(arr[mid] >= val){
                index = mid;
                right = mid - 1;
            } else if (arr[mid] < val) {
                left = mid + 1;
            }
        }
        return index;
    }
    public static int test(int [] arr,int val){
        if(arr==null || arr.length==0){
            return  -1;
        }
        if(arr[arr.length - 1] < val){
            return  -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= val){
                return i;
            }
        }
        return -1;

    }
    public static void printArr(int [] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
}
