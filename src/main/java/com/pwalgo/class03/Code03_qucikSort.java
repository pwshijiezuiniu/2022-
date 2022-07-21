package com.pwalgo.class03;

import com.pwalgo.util.ArrTools;

import java.util.Arrays;

public class Code03_qucikSort {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 100; i++) {
            int [] arr = ArrTools.getRandomArr(10,10);
            int [] copy = Arrays.copyOf(arr,arr.length);
            comparator(copy);
            quickSort(arr);
            if(!isEqualArr(arr,copy)){
                print(arr);
                System.out.println();
                print(copy);
                flag = false;
                break;
            }
        }
        System.out.println(flag?"yes":"fucking");
    }
    public static void print(int [] arr){
        Arrays.stream(arr).forEach(a-> System.out.print(a+","));
    }
    public static void comparator(int [] arr){
        Arrays.sort(arr);
    }
    public static  void quickSort(int [] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr,0,arr.length-1);
    }
    public static void process(int [] arr,int left,int right){
        if(left >= right){
            return;
        }
        int [] index = partition(arr,left,right);
        process(arr,left,index[0]);
        process(arr,index[1],right);

    }
    public static int [] partition(int [] arr,int left,int right){
        int minBorder = left - 1;
        int MaxBorder = right;
        int index = left;
        while(index < MaxBorder){
            if(arr[index] < arr[right]){
                swap(arr,++minBorder,index++);
            } else if (arr[index]>arr[right]) {
                swap(arr,--MaxBorder,index);
            }else {
                index++;
            }
        }
        swap(arr,MaxBorder,right);
        return new int[]{minBorder,MaxBorder + 1};
    }
    public static void swap(int [] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
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
}
