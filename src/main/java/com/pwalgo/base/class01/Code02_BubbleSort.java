package com.pwalgo.base.class01;

import com.pwalgo.base.util.ArrTools;

import java.util.Arrays;

public class Code02_BubbleSort {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 500; i++) {
            int[] arr1 = ArrTools.getRandomArr(20, 20);
            int [] arr2 = copy(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1,arr2)) {
                flag = false;
            }
        }
        System.out.println(flag?"yes":"fucking");

    }
    public static void bubbleSort(int [] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length-1; j >i ; j--) {
                if (arr[j-1] > arr[j]) {
                    swap(arr,j-1,j);
                }
            }
        }
    }
    public static void swap(int [] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    
    public static void comparator(int [] arr){
        Arrays.sort(arr);
    }
    public static boolean isEqual(int [] arr1,int [] arr2){
        if(arr1.length != arr2.length || arr1==null&&arr2!=null || arr1!=null&&arr2==null){
            return false;
        }
        if (arr1 == null || arr2 == null){
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static void printArr(int [] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static int [] copy(int [] arr){
        return Arrays.copyOf(arr, arr.length);
    }

}
