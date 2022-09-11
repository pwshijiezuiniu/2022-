package com.pwalgo.advance.class01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Code03_MaxK {
    public static void main(String[] args) {
        int [] nums1 = {1,8,10,19,28};
        int [] nums2 = {4,5,6,7};
        Arrays.stream(getMaxK(nums1, nums2, 6)).forEach(System.out::println);
    }
    public static class Nums {
        public int index1;
        public int index2;
        public int nums;
        public Nums(int i,int j,int k){
            this.index1 = i;
            this.index2 = j;
            this.nums = k;
        }


    }
    //K * log(K)
    public static int [] getMaxK(int [] nums1,int [] nums2,int k){
        int [] res = new int [k];
        PriorityQueue<Nums> priorityQueue = new PriorityQueue<>((a,b)->b.nums-a.nums);
        priorityQueue.add(new Nums(nums1.length-1, nums2.length-1,nums1[nums1.length-1]+nums2[nums2.length-1]));
        while(k > 0){
            Nums poll = priorityQueue.poll();
            res[--k] = poll.nums;
            if(poll.index1 > 0){
                priorityQueue.add(new Nums(poll.index1-1, poll.index2, nums1[poll.index1-1]+nums2[poll.index2]));
            }
            if(poll.index2 > 0){
                priorityQueue.add(new Nums(poll.index1, poll.index2-1, nums1[poll.index1]+nums2[poll.index2-1]));
            }


        }
        return res;
    }
}
