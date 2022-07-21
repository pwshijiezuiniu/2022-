package com.pwalgo.class03;

import com.pwalgo.util.ArrTools;

import java.util.Arrays;

public class Code01_MergeSort {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 1000; i++) {
            int[] arr = ArrTools.getRandomArr(10, 10);
            int[] cArr = Arrays.copyOf(arr, arr.length);
            mergeSort2(arr);
            comparator(cArr);
            if(!isSame(arr,cArr)){
                flag = false;
                break;
            }
        }
        System.out.println(flag?"yes":"fucking!!!");

    }
    public static void mergeSort2(int [] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        cycleMergeSort(arr);
    }
    public static void cycleMergeSort(int [] arr){
        int N = arr.length;
        int mergeSize = 1;
        while(mergeSize < N){
            int L = 0;
            while(L < N){
                int M = L + mergeSize - 1;
                if(M >= N){
                    break;
                }
                int R = Math.min(N-1,L+2*mergeSize - 1);

                merge(arr,L,M,R);
                L +=2*mergeSize;
            }
            if(mergeSize > N/2){
                break;
            }
            mergeSize <<= 1;
        }
    }
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        recursiveMergeSort(arr, 0, arr.length - 1);
    }
    public static void recursiveMergeSort(int [] arr,int left,int right){
        if(left == right){
            return ;
        }
        int mid = left + ((right - left) >> 1);
        recursiveMergeSort(arr,left,mid);
        recursiveMergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    public static void merge(int [] arr,int left,int mid,int right){
        int [] helper = new int[right - left + 1];
        int temLeft = left;
        int temright = mid+1;
        int i = 0;
        while(temLeft <= mid && temright <= right){
            helper[i++] = arr[temLeft] < arr[temright]? arr[temLeft++] : arr[temright++];
        }
        while(temLeft <= mid){
            helper[i++] = arr[temLeft++];
        }
        while(temright <= right){
            helper[i++] = arr[temright++];
        }
        for (int j = 0; j < helper.length; j++) {
            arr[left+j] = helper[j];
        }
    }
    public static void comparator(int [] arr){
        Arrays.sort(arr);
    }
    public static boolean isSame(int [] arr1,int [] arr2){
        if(arr1==null&&arr2!=null || arr2==null&&arr1!=null || arr1.length!=arr2.length){
            return false;
        }
        if(arr1 == null && arr2 == null){
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
