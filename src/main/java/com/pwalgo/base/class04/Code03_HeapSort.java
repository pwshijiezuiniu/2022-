package com.pwalgo.base.class04;

import com.pwalgo.base.util.ArrTools;

import java.util.Arrays;

public class Code03_HeapSort {
    public static void main(String[] args) {
       boolean flag = true;
        for (int i = 0; i < 10; i++) {
            int [] arr = ArrTools.getRandomArr(10,10);
            int[] copy = Arrays.copyOf(arr, arr.length);
            heapSort(arr);
            Arrays.sort(copy);
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
    public static void heapSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        for (int i = arr.length-1; i > 0 ; i--) {
            swap(arr,0,i);
            heapify(arr,i);
        }
    }
    public static void heapInsert(int [] arr,int heapSize){
        //arr[heapSize] = value;
        int index = heapSize;
        while(index >(index - 1)/2){
            if(arr[index] > arr[(index - 1)/2]){
                swap(arr,index,(index - 1)/2);
            }else {
                break;
            }
            index = (index - 1)/2;
        }
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
    public static void heapify(int [] arr,int heapSize){
        int left = 1;
        int cur = 0;
        int lagerest;
        while(left < heapSize){
            lagerest = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1:left;
            lagerest = arr[cur] > arr[lagerest] ? cur:lagerest;
            if(cur == lagerest){
                break;
            }
            swap(arr,cur,lagerest);
            cur = lagerest;
            left = cur*2+1;
        }
    }
    public static void swap(int [] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
