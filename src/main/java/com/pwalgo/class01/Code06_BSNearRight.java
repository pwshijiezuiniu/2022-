package com.pwalgo.class01;

import com.pwalgo.util.ArrTools;

import java.util.Arrays;

public class Code06_BSNearRight {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 5000; i++) {
            int val = (int) (Math.random()*51);
            int [] arr = ArrTools.getRandomArr(500,500);
            Arrays.sort(arr);
            if (test(arr,val) != bsNearRight(arr,val)) {
                printArr(arr);
                System.out.println("key::"+val+"bsNearLeft"+arr[bsNearRight(arr,val)]+"test"+arr[test(arr,val)]);
                flag = false;
                break;
            }
        }
        System.out.println(flag?"yes":"fucking");
    }
    public static int bsNearRight(int [] arr,int val){
        if (arr == null || arr.length ==0){
            return -1;
        }
        int left = 0 , right = arr.length - 1;
        int index = -1;
        while(left <= right){
            int mid = left + ((right - left)>>1);
            if(arr[mid] <= val){
                index = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }
        return index;
    }
    public static int test(int [] arr,int val){
        if (arr == null || arr.length ==0){
            return -1;
        }
        for (int i = arr.length - 1; i >=0 ; i--) {
            if(arr[i] <= val){
                return i;
            }
        }
        return -1;
    }
    public static void printArr(int [] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
}
