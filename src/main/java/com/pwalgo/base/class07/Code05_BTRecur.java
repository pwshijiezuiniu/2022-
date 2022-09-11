package com.pwalgo.base.class07;

import java.util.ArrayList;
import java.util.List;

public class Code05_BTRecur {
    public static void main(String[] args) {
        Node tree = new Node(0);
       tree.left = new Node(3);
       tree.left.left = new Node(2);
        tree.left.right = new Node(5);
        tree.left.right.left = new Node(6);
        tree.right = new Node(4);
        tree.right.right = new Node(7);
        System.out.println(findBiggestSearchBT(tree).nodeCount);
    }
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }
    public static class Info {
        public int height;
        public int maxLen;
        public Info(int height, int maxLen){
            this.height = height;
            this.maxLen = maxLen;
        }
    }
    public static int findMaxLenStart(Node head){
        if(head == null){
            return 0;
        }
        return findMaxlen(head).maxLen;
    }
    public static Info findMaxlen(Node node){
        if(node == null){
            return new Info(0,0);
        }
        Info left = findMaxlen(node.left);
        Info right = findMaxlen(node.right);
        int max = left.maxLen > right.maxLen? left.maxLen: right.maxLen ;
        max = max > left.height + right.height + 1? max : left.height + right.height + 1;
        return new Info(Math.max(left.height,right.height) + 1,max);
    }



    public static class Msg{
        public int nodeCount;
        public Node root;
        public Msg(int nodeCount,Node root){
            this.nodeCount = nodeCount;
            this.root = root;
        }
    }
    public static Node findBiggestSearchBTStart(Node head){
        if(head == null ){
            return head;
        }
        return findBiggestSearchBT(head).root;
    }

    public static Msg findBiggestSearchBT(Node node){
        if(node == null){
            return new Msg(0,null);
        }
        Msg left = findBiggestSearchBT(node.left);
        Msg right = findBiggestSearchBT(node.right);
        if(left.root == node.left && right.root == node.right){
            if((left.root == null ||left.root.value < node.value) && (right.root == null ||right.root.value > node.value)){
                return new Msg(left.nodeCount +right.nodeCount + 1,node);
            }
        }
        return left.nodeCount > right.nodeCount ? left : right;


    }
    public static class Staff{
        public int  happy;
        public List<Staff> subordinates;
        public Staff(int happy){
            this.happy = happy;
            subordinates = new ArrayList<>();
        }
    }
    public static class Message{
        public int comeMax;
        public int absentMax;
        public Message(int comeMax,int absentMax){
            this.comeMax = comeMax;
            this.absentMax = absentMax;
        }
    }
    public int getMaxHappy(Staff staff){
        if(staff == null){
            return 0;
        }
        Message process = process(staff);
        return Math.max(process.absentMax,process.comeMax);
    }
    public static Message process(Staff staff){
        if(staff.subordinates.isEmpty()){
            return new Message(staff.happy,0);
        }
        int comeMax = staff.happy;
        int absentMax = 0;
        for (Staff item: staff.subordinates){
            Message single = process(item);
            comeMax +=single.absentMax;
            absentMax +=single.comeMax;
        }
        return new Message(comeMax,absentMax);
    }
}
