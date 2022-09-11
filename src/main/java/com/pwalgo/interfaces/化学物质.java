package com.pwalgo.interfaces;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 化学物质 {
    //主函数
    public String func(String  chemicals){
        //保证输出顺序
        Queue<String> sort = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        char[] chars = chemicals.toCharArray();
        int last = 0;
        int cur = 0;
        while(cur < chars.length){
            if(chars[cur] =='('){
                process(map,chars,last,cur,1,sort);
                last = cur+1;
                while(chars[cur] != ')'){cur++;}
                process(map,chars,last,cur,chars[cur+1]-'0',sort);
                cur +=2;
                last = cur;

            }
            cur++;
        }
        if(cur != last +1){
            process(map,chars,last,cur,1,sort);
        }
        StringBuilder sb = new StringBuilder();
        while(!sort.isEmpty()){
            String s = sort.poll();
            sb.append(s);
            sb.append(map.get(s));
        }
        return sb.toString();
    }
    //帮助生成字符串
    public String helper(char [] chars,int left,int right){
        if(Character.isDigit(chars[right-1])){
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(;left<right;left++){
            sb.append(chars[left]);
        }
        return sb.toString();
    }

    public void process(HashMap<String,Integer> map,char [] chars,int start,int end,int base,Queue<String> sort){

        while(start < end){

            int next = start+1;
            while(next < end && !Character.isUpperCase(chars[next]) ){
                next++;

            }
            int count = base;

            if(Character.isDigit(chars[next-1])){
                count = (chars[next-1] - '0')*base;
            }
            String temp = helper(chars,start,next);
            if(!map.containsKey(temp)){
                sort.add(temp);
            }
            map.put(temp,map.getOrDefault(temp,0)+count);
            start = next;
        }
    }
}
