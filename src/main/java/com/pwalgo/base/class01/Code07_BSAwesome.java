package com.pwalgo.base.class01;

import com.pwalgo.base.util.ArrTools;

import java.util.Arrays;

public class Code07_BSAwesome {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 5000; i++) {
            int [] arr = ArrTools.getRandomArr(10,20);
            if(!isRight(arr,bsAwesome(arr))){
                System.out.println( arr.length ==0);
                System.out.println((bsAwesome(arr)));
                printArr(arr);
                flag = false;
                break;
            }


        }
        System.out.println(flag?"yes":"fucking");


    }
    //找到局部最小值
    public static int bsAwesome(int [] arr){
        if(arr == null || arr.length ==0){
            return -1;
        }
        if(arr.length == 1){
            return 0;
        }
        if(arr.length ==2){
            return arr[0] <= arr[1]? 0:1;
        }
        if(arr.length > 2){
            if(arr[0] <= arr[1]){
                return 0;
            }
            if(arr[arr.length-1] <= arr[arr.length-2]){
                return arr.length-1;
            }
        }
        int left = 0,right = arr.length - 1;
        while(left <= right) {
            int mid = left + ((right - left)>>1);
            if(arr[mid] <= arr[mid -1] && arr[mid] <= arr[mid +1]){
                return mid;
            } else if (arr[mid] > arr[mid-1]) {
                right = mid ;
            }else {
                left = mid ;
            }
        }
        return -1;
    }
    public static boolean test(int [] arr, int index){
        if(index == -1){
           return arr ==null || arr.length ==0;
        }else {
            if(index == 0){
                return arr.length == 1 ||arr[0] <= arr[1] ;
            } else if (index == arr.length-1) {
                return arr[arr.length-1] <= arr[arr.length-2];
            }
            return arr[index] <= arr[index-1] && arr[index] <= arr[index+1];
        }
    }
    public static void printArr(int [] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static boolean isRight(int[] arr, int index) {
        if (arr.length <= 1) {
            return true;
        }
        if (index == 0) {
            return arr[index] <= arr[index + 1];
        }
        if (index == arr.length - 1) {
            return arr[index] <= arr[index - 1];
        }
        return arr[index] <= arr[index - 1] && arr[index] <= arr[index + 1];
    }
}
