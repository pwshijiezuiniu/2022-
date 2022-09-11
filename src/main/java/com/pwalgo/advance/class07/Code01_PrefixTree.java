package com.pwalgo.advance.class07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeMap;

public class Code01_PrefixTree {
    public static void main(String[] args) {
        String s = "a/b/c/d/e/f/g/h/i/j/k/l/m/n/o/p/q/r/s/t/u/v/w/x/y/z";
        System.out.println(s);
        Arrays.stream(s.split("/")).forEach(System.out::println);
    }
    public static class Node{
        TreeMap<String,Node> path;
        public Node(){
            path = new TreeMap<>();
        }
    }
    public static Node getPrefixTree(String [] paths){
        Node head = new Node();
        for (String curRoad : paths) {
            String [] str = curRoad.split("/");
            Node temp = head;
            for (int i = 0; i < str.length; i++) {
                if(!temp.path.containsKey(str[i])){
                    temp.path.put(str[i],new Node());
                }
                temp = temp = temp.path.get(str[i]);
            }
        }
        return head;

    }
    public static void DFS(Node head){
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        HashSet<Node> set = new HashSet<>();
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            if(cur.path.size() == 0){
                System.out.println();
            }
        }

    }
}
