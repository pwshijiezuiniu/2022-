package com.pwalgo.class05;

import com.pwalgo.util.ArrTools;

import java.util.Arrays;

public class Code02_RadixSort {
    public static void main(String[] args) {
        int[] randomArr = generateArr(20, 1000);
        Arrays.stream(randomArr).forEach(System.out::println);
        radixSort(randomArr);
        Arrays.stream(randomArr).forEach(System.out::println);

    }
    public static void radixSort(int [] arr){
        if(arr==null || arr.length<2){
            return;
        }
        int digit = getDigit(arr);
        radixSort(arr,0,arr.length-1,digit);
    }
    public static int getDigit(int [] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        //System.out.println(max);
        int digit = 0;
        while(max > 0){
            max /=10;
            digit++;
        }
        System.out.println("digit is "+digit);
        return digit;
    }
    public static void radixSort(int [] arr,int left,int right,int digit){
        final int radix = 10;
        int [] helper = new int[right - left + 1];
        for (int i = 1; i <= digit; i++) {
            int [] count = new int[10];
            for (int j = left; j <= right; j++) {
                int index = getDigit(arr[j],i);
                count[index]++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j-1];
            }
            for (int j = right; j >=left ; j--) {
                int index = getDigit(arr[j],i);
                helper[count[index] -1] = arr[j];
                --count[index];
            }
            for (int j = left,k = 0; j <=right ; j++,k++) {
                arr[j] = helper[k];
            }
        }
    }
    public static int getDigit(int num,int digit){
        while(--digit > 0){
            num /=10;
        }
        //System.out.println(num%10);
        return num%10;
    }
    public static int[] generateArr(int maxSize,int maxValue){
        int [] arr = new int[(int) (Math.random()*(maxSize+1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*(maxValue+1));
        }
        return arr;
    }
}
