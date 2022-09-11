package com.pwalgo.base.class07;

public class Code01_IsBST {
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 100;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBST(head) != isBST2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
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
    public static class Info{
        public boolean isBST;
        public int max;
        public int min;
        public Info(Boolean isBST,int max,int min){
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
    public static boolean isBST(Node head){
        if(head == null){
            return true;
        }
        return process(head).isBST;
    }
    public static Info process(Node node){
        if(node == null){
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        boolean isBST = false;
        int max;
        int min;
        if ((leftInfo == null || (leftInfo.max < node.value && leftInfo.isBST)) &&(rightInfo == null || (rightInfo.min > node.value && rightInfo.isBST)) )
            isBST = true;
        if(leftInfo ==null && rightInfo ==null){
            max = min = node.value;
        }else if (leftInfo !=null && rightInfo ==null){
            max = Math.max(node.value, leftInfo.max);
            min = Math.min(node.value, leftInfo.min);
        }else if(leftInfo ==null) {
            max = Math.max(node.value, rightInfo.max);
            min = Math.min(node.value, rightInfo.min);
        }else {
            max = Math.max(rightInfo.max, Math.max(leftInfo.max, node.value));
            min = Math.min(rightInfo.min, Math.min(leftInfo.min, node.value));
        }


        return new Info(isBST,max,min);
    }

    public static boolean isBST2(Node head) {
        if (head == null) {
            return true;
        }
        return process1(head).isBST;
    }
    public static Info process1(Node x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process1(x.left);
        Info rightInfo = process1(x.right);
        int max = x.value;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
        }
        int min = x.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
        }
        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        if (leftInfo != null && leftInfo.max >= x.value) {
            isBST = false;
        }
        if (rightInfo != null && rightInfo.min <= x.value) {
            isBST = false;
        }
        return new Info(isBST, max, min);
    }
}
