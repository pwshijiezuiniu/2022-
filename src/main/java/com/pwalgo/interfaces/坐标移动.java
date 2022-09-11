package com.pwalgo.interfaces;

public class 坐标移动 {
    public static void main(String[] args) {
        String prep = "ABC;AKL;DA1;";
        char[] chars = prep.toCharArray();
        int [] res = process(chars);
        System.out.println(res[0]+","+res[1]);
    }
    public static int[] process(char [] chars){
        int [] res = new int[2];
        int i = 0;
        while(i < chars.length){
            int first =i;
            char dire = chars[first];
            while(chars[i] != ';'){
                i++;
            }
            int num = num(chars,first+1,i-1);
            i++;
            if( dire== 'A'){
                res[0] -= num;
            } else if (dire == 'D') {
                res[0] += num;
            } else if (dire == 'W') {
                res[1] += num;
            }else if(dire == 'S'){
                res[1] -= num;
            }
        }
        return res;
    }
    public static int num(char [] chars,int left,int right){
        if(left == chars.length || chars[left]<'1' || chars[left] > '9'){
            return 0;
        }
        int res = 0;
        for(;left<=right;left++){
            if(chars[left]<'0' || chars[left] > '9'){
                return 0;
            }
            res = res*10 + (int)(chars[left] -'0');
        }
        return res;
    }
}
