package com.pwalgo.class03;

import com.pwalgo.util.ArrTools;

import java.util.Arrays;

public class Code02_MinSum {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 1000; i++) {
            int[] arr1 = ArrTools.getRandomArr(100, 100);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);
            int a = getMinSumPlus(arr1);
            int b = comparator(arr2);
            if(a !=b){
                printArr(arr3);
                System.out.println();
                printArr(arr2);

                System.out.println();
              System.out.println("get:"+a+":::compara"+b+"第"+i+"次");
//                System.out.println(getMinSumPlus(arr) == comparator(arr));
                flag = false;
                break;
            }
        }
        System.out.println(flag?"yes":"fucking!");
    }
    public static int getMinSumPlus(int [] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }

        return getMin(arr,0,arr.length -1 );
    }
    public static int getMin(int [] arr,int left,int right){
        if(left == right){
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int R = getMin(arr, left, mid);
        int L = getMin(arr,mid + 1,right);
        int sum = merge(arr,left,mid,right);
        return sum + R + L;
    }
    public static int merge(int [] arr,int left,int mid,int right){
        int L = left,R = mid + 1;
        int sum = 0;
        int i = 0;
        int [] helper = new int[right - left + 1];
        while(L <=mid && R<=right){
            if(arr[L] < arr[R]){
                sum += arr[L] * (right- R +1);
                helper[i++] = arr[L++];
            }else{
                helper[i++] = arr[R++];
            }
        }
        while(L <= mid){
            helper[i++] = arr[L++];
        }
        while(R <= right){
            helper[i++] = arr[R++];
        }
        for (int j = 0; j < helper.length; j++) {
            arr[left + j] = helper[j];
        }
        return sum;
    }
    //示和警银数组示和数左边比它小的数的总和，叫数的小和，所有数的小和累加起来
    public static int getMinSum(int [] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum +=getMinSumLeft(arr,i,i);
        }
        return sum;
    }
    public static int getMinSumLeft(int [] arr,int now,int index){
        if(index == 0 || now < 0){
            return 0;
        }
        return arr[now]<arr[index]? arr[now]+getMinSumLeft(arr,now-1,index) : getMinSumLeft(arr,now-1,index);
    }
    public static int comparator(int [] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return sum;
    }
    public static void printArr(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
