package com.pwalgo.base.class01;

import com.pwalgo.base.util.ArrTools;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class Code01_SelectionSort {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 5000; i++) {
            int [] arr1 = ArrTools.getRandomArr(500,500);
            int [] arr2 = copyArr(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if(!isEqualArr(arr1,arr2)){
                arrToString(arr1);
                arrToString(arr2);
                flag = false;
                break;
            }
        }
        System.out.println(flag?"yes":"fucking");
        int [] arr1 = ArrTools.getRandomArr(20,500);
        int [] arr2 = copyArr(arr1);
        selectionSort(arr1);
        comparator(arr2);
        arrToString(arr1);
        arrToString(arr2);
        System.out.println(arr1 == arr2);

    }
    public static void selectionSort(int [] arr){
        if(arr == null || arr.length == 1){
            return;
        }
        if(arr.length == 2 && arr[0] < arr[1]){
            return;
        }
        int minIndex;
        for (int i = 0; i < arr.length ; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;

            }
            swap(arr,i,minIndex);
        }

    }
//    public static int [] getRandomArr(int maxSize,int maxVal){
//        int [] arr = new int [(int) (Math.random()*(maxSize+1))];
//        //Arrays.stream(arr).peek()
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random()*(maxVal+1)) - (int) (Math.random()*(maxVal+1));
//        }
//        return arr;
//    }
    public static boolean isEqualArr(int [] arr1,int [] arr2){
        if(arr1.length != arr2.length || arr1 == null&&arr2 != null || arr1!=null&& arr2==null){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static int[] copyArr(int [] arr){
        return Arrays.stream(arr).toArray();
    }
    public static void arrToString(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void comparator(int [] arr){
         sort(arr);
    }
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
