package com.pwalgo.base.class11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code03_FaceBook {
    public static void main(String[] args) {
        String str = "1122271213";
        System.out.println(cellect(str,0));
        System.out.println(cellectByDp(str));
    }
    public static void doCellect(String str, int index, List<String> collect,String path){
        if(index == str.length()){
            collect.add(path);
            return;
        }
        if(str.charAt(index)=='1'){
            doCellect(str,index+1,collect,path+'A');
            if(index < str.length()-1){
                doCellect(str,index+2,collect,path+(char)(str.charAt(index+1)-'0'+'J'));
            }
        } else if (str.charAt(index) == '2') {
            doCellect(str,index+1,collect,path+'B');
            if(index < str.length()-1 && str.charAt(index+1)<='6'){
                doCellect(str,index+2,collect,path+(char)(str.charAt(index+1)-'0'+'T'));
            }
        } else if (str.charAt(index) != '0') {
            doCellect(str,index+1,collect,path+(char)(str.charAt(index)-'1'+'A'));
        } else {
            return;
        }
    }
    public static int cellect(String str,int index){
        if(str.length() == index){
            return 1;
        }
        int res = 0;
        if(str.charAt(index)=='1'){

            if(index < str.length()-1){
               res += cellect(str,index+2);
            }
            res += cellect(str,index+1);
        } else if (str.charAt(index) == '2') {
           res += cellect(str,index+1);
            if(index < str.length()-1 && str.charAt(index+1)<='6'){
              res += cellect(str,index+2);
            }
        } else if (str.charAt(index) != '0') {
           res +=cellect(str,index+1);
        }

        return res;
    }
    public static int cellectByDp(String str){
        int [] dp = new int[str.length()+1];
        dp[str.length()] = 1;
        for (int i = str.length()-1; i >=0; i--) {
            char c = str.charAt(i);
            if(c == '1'){
                dp[i] +=dp[i+1];
                if(i < str.length()-1){
                    dp[i] +=dp[i+2];
                }
            } else if (c == '2') {
                dp[i] +=dp[i+1];
                if(i < str.length()-1 && str.charAt(i+1) <= '6'){
                    dp[i] +=dp[i+2];
                }
            }else if(c!='0'){
                dp[i] +=dp[i+1];
            }
        }
        return dp[0];
    }

}
