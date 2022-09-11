package com.pwalgo.advance.class02;

public class Code01_SlidingWindow {
//    public static void main(String[] args) {
//        //System.out.println(bigLeftest(new int[]{1, 2,5,6,8,9,9,10,12,15}, -1));
//        testQ1();
//    }
//    public static void testQ1(){
//        int [] arr = new int[]{2,4,8,9,12,17};
//        int L = 5;
//        System.out.println(question1(arr,L));
//    }
    //给定一个有序数组arr，代表数轴上从左到右有n个点arr[o]、arr[1]...arr[n—1]，给定一个正数L，
    // 代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点。
    public static int question1(int [] nodes,int L){
        if(nodes == null || nodes.length == 0 || L==0){
            return 0;
        }
        int res = 0;

        for(int i = 0;i < nodes.length;i++){
            int left = nodes[i] - L;
            res = Math.max(i - bigLeftest(nodes,left) + 1,res);
        }
        return res;
    }
    //找到大于等于某数的最左位置
    public static int bigLeftest(int [] arr,int num){
        int right = arr.length - 1;
        int left = 0;
        while(left < right){
            int mid = left + ((right - left)>>1);
            if(arr[mid] >= num){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return arr[left] >= num ? left : -1;
    }
}
