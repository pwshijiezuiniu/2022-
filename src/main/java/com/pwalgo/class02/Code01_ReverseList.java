package com.pwalgo.class02;

public class Code01_ReverseList {
    public static void main(String[] args) {
        DoubleNode listHead = generateRandomDoubleLinkedList(10, 10);
        printDoubleLinkedList(listHead);
        DoubleNode newHead = reverseDoubleLinkedList(listHead);
        System.out.println();
        printDoubleLinkedList(newHead);
    }
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }


    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int value){
            this.value = value;
        }
    }
    public static DoubleNode generateRandomDoubleLinkedList(int maxSize,int maxValue){
        int len = (int) (Math.random()*(maxSize+1));
        DoubleNode head = new DoubleNode((int) (Math.random()*(maxValue+1)));
        DoubleNode pre = head;
        while(--len >0){
            DoubleNode next = new DoubleNode((int) (Math.random()*(maxValue+1)));
            pre.next = next;
            next.last = pre;
            pre = next;
        }
        return head;
    }
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static Node generateRandomLinkedList(int maxSize,int maxValue){
        int len = (int) (Math.random()*(maxSize+1));
        Node head = new Node((int) (Math.random()*(maxValue+1)));
        Node pre = head;
        while(--len > 0){
            Node next = new Node((int) (Math.random()*(maxValue+1)));
            pre.next = next;
            pre = next;
        }
        return head;
    }
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
    public static void printLinkedList(Node head){
        while(head != null){
            System.out.print(head.value+",");
            head = head.next;
        }
    }
    public static void printDoubleLinkedList(DoubleNode head){
        while(head != null){
            System.out.print(head.value+",");
            head = head.next;
        }
    }
}
