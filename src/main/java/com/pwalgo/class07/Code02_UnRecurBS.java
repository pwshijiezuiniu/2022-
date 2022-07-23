package com.pwalgo.class07;

import java.util.Stack;

public class Code02_UnRecurBS {
    public static void main(String[] args) {
        Node tree = new Node(3);
        tree.left = new Node(4);
        tree.left.left = new Node(7);
        tree.left.right = new Node(9);
        tree.right = new Node(10);
        tree.right.left = new Node(0);
        tree.right.right = new Node(1);
        midBs(tree);
    }
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }
    public static void midBs(Node head){
//        if(head == null){
//            return;
//        }
//        Stack<Node> stack = new Stack<>();
//        while(!stack.isEmpty() || head != null){
//            if(head != null){
//                stack.push(head);
//                head = head.left;
//            }else{
//                head = stack.pop();
//                System.out.println(head.value);
//                head = head.right;
//            }
//        }
        if(head == null){
            return ;
        }
        Stack<Node> stack = new Stack<>();
        //stack.add(head);
        while(!stack.isEmpty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }
    public static void afterBs(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node c = null;
        Node h = null;
        while(!stack.isEmpty()){
            c = stack.peek();
            if(c.left != null && h != c.left &&h != c.right){
                stack.push(c.left);
            }else if(c.right != null && h != c.right){
                stack.push(c.right);
            }else {
                stack.pop();
                System.out.println(c.value);
                h = c;
            }
        }
    }
    public static void beforeBs(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.value);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }
}
