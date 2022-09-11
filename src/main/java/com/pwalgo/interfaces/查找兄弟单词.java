package com.pwalgo.interfaces;

import java.util.*;

public class 查找兄弟单词 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] strs = new String[scanner.nextInt()];
        for(int i =0;i < strs.length;i++){
            strs[i] = scanner.next();
        }
        String x = scanner.next();
        int sort = scanner.nextInt();
        Arrays.sort(strs);
        HashMap<Character,Integer> map = new HashMap();
        for(int i = 0;i < x.length();i++){
            map.put(x.charAt(i),map.getOrDefault(x.charAt(i),0)+1);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if(x.length() == strs[i].length() && !x.equals(strs[i]) && isBro(map,strs[i])){
                list.add(strs[i]);
            }
        }
        System.out.println(list.size());
        if(sort <= list.size()){
            System.out.println(list.get(sort-1));
        }



    }
    public static boolean isBro(HashMap<Character,Integer> map,String com){
        HashMap<Character,Integer> temp = new HashMap();
        for(int i = 0;i < com.length();i++){
            temp.put(com.charAt(i),temp.getOrDefault(com.charAt(i),0)+1);
        }
        for (Character character : map.keySet()) {
            if(!temp.containsKey(character) || map.get(character) != temp.get(character)){
                System.out.println(com);
                return false;
            }
        }


        return true;
    }

}
