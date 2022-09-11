package com.pwalgo.base.class11;

import java.util.ArrayList;
import java.util.List;

public class Code02_AllSort {
    public static void main(String[] args) {
        char [] str = "aabb".toCharArray();

        List<String> list = new ArrayList<>();
        allSort(str,list,0);
        for (String s : list) {
            System.out.println(s.toString());
        }
    }

    public static void allSort(char[] str, List<String> list,int index){
        if(index == str.length){
            list.add(String.valueOf(str));
        }
        for(int i = index;i < str.length;i++){
            if(str[i] == str[index]&&index != i){
                continue;
            }
            char c = str[i];
            swap(str,i,index);
            //String h= path+ c;
            //System.out.println(h);
            allSort(str,list,index+1);
            swap(str,i,index);
        }

    }
    public static void swap(char [] arr,int left,int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
