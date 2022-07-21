package com.pwalgo.class01;

import com.pwalgo.util.ArrTools;

import java.util.Arrays;

public class Code03_InsertionSort {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 500; i++) {
            int[] arr1 = ArrTools.getRandomArr(500, 500);
            int [] arr2 = copy(arr1);
            insertSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1,arr2)) {
                flag = false;
            }
        }
        System.out.println(flag?"yes":"fucking");
    }
    public static void insertSort(int [] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j>0&&arr[j] < arr[j-1]; j--) {
                swap(arr,j,j-1);
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
