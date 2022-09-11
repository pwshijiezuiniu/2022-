package com.pwalgo;

import java.util.*;

public class MovingAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        String c = scanner.next();
        String d = scanner.next();
        System.out.println(a+","+b+","+c+","+d);
//        MovingAverage movingAverage = new MovingAverage(3);
//        System.out.println(movingAverage.next(1));
//        System.out.println(movingAverage.next(10));
//        System.out.println(movingAverage.next(5));
    }
    static class LRU{
        HashMap<Integer,Node> map;
        Node head;
        Node tail;
        int size;
        public LRU(int size){
            map = new HashMap(size);
            this.size = size;
        }
        static class Node{
            int val;
            Node next;
            Node pre;
            public Node(){}
            public Node(int val){this.val = val;}
        }
        public void insertHead(Node cur){
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                Node temp = head;
                head = cur;
                head.next = temp;
                temp.pre = head;
            }
        }
        public void insertTail(Node cur){
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                Node temp = tail;
                tail = cur;
                tail.pre = temp;
                temp.next = tail;
            }
        }
        public void deleteFromTail(){
            if(tail == head){
                tail = null;
                head = null;
            }else{
                Node temp = tail;
                tail = temp.pre;
                tail.next = null;
                temp.pre = null;
            }
        }
        public void deleteFromHead(){
            if(tail == head){
                tail = null;
                head = null;
            }else{
                Node temp = head;
                head = temp.next;
                head.pre = null;
                temp.next = null;
            }
        }
        public void deleteFromMid(Node cur){
            Node pren = cur.pre;
            Node nextn = cur.next;
            pren.next = nextn;
            nextn.pre = pren;
            cur.pre = null;
            cur.next = null;
        }
        public void delete(Node cur){
            if(cur == head){
                deleteFromHead();
            }else if(cur == tail){
                deleteFromTail();
            }else{
                deleteFromMid(cur);
            }
        }
        public void set(int val){
            if(!map.containsKey(val)&& map.size()< size){
                Node temp = new Node(val);
                map.put(val,temp);
                insertHead(temp);
            }else if(map.containsKey(val)){
                Node temp = map.get(val);
                delete(temp);
                insertHead(temp);
            }else{
                deleteFromTail();
                Node temp = new Node(val);
                map.put(val,temp);
                insertHead(temp);
            }
        }
        public Double getAverage(){
            int sum = 0;
            for(int it: map.keySet()){
                sum+=it;
            }
            return sum/(double)size;
        }
    }
    LRU lru;
    public MovingAverage(int size) {
        lru= new LRU(size);
    }

    public double next(int val) {
        lru.set(val);
        return lru.getAverage();
    }


    //        int index = 0;
//        while(index < chars.length){
//
//            int next = index+1;
//            while(next < chars.length && !Character.isUpperCase(chars[next]) ){
//                next++;
//
//            }
//            int count = 1;
//
//            if(Character.isDigit(chars[next-1])){
//                count = chars[next-1] - '0';
//            }
//            System.out.println(index+","+next);
//            String temp = helper(chars,index,next);
//            map.put(temp,map.getOrDefault(temp,0)+count);
//            index = next;
//        }
}
