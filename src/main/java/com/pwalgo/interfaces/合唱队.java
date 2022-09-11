package com.pwalgo.interfaces;

import java.util.Arrays;
import java.util.Scanner;

public class 合唱队 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int [] height = new int[len];
        for(int i = 0;i < len;i++){
            height[i] = s.nextInt();
        }
        int [] befSmall = new int[len];
        int [] aftSmall = new int[len];
        int [] pre = new int[len];
        int [] post = new int[len];
        int cur = -1;
        for(int i = 0;i < len;i++){
            if(i == 0 || height[i] > pre[cur]){
                pre[++cur] = height[i];
                befSmall[i] = cur+1;
            }else{
                int l=0,r=cur;
                while(l<r){
                    int mid = l + ((r - l)>>1);
                    if(pre[mid] >= height[i]){
                        r = mid;
                    }else{
                        l = mid+1;
                    }
                }
                pre[l] = height[i];
                befSmall[i] = l+1;
            }

        }
        cur = len;
        for(int i = len-1;i >=0;i--){
            if(i == len-1 || height[i] > post[cur]){
                post[--cur] = height[i];
                aftSmall[i] = len-cur;
            }else{
                int l=cur,r=len-1;
                while(l<r){
                    int mid = l + ((r - l+1)>>1);
                    if(post[mid] >= height[i]){
                        l = mid;
                    }else{
                        r = mid-1;
                    }
                }

                post[l] = height[i];
                aftSmall[i] = len - l;
            }

        }
        int res = 0;
        for(int i = len-1;i >0;i--){
            res = Math.max(res,befSmall[i] + aftSmall[i]-1);
        }
        System.out.println(len - res);
    }
}
