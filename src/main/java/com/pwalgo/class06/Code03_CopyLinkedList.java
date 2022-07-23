package com.pwalgo.class06;

public class Code03_CopyLinkedList {
    public static class Node{
        public int value;
        public Node next;
        public Node random;
        public Node(int value){
            this.value = value;
        }
    }
    public Node copyLinkedList(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next;
        while(cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        Node temp = head;
        while(temp != null){
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }
        Node headN = head.next;
        Node res = headN;
        while(headN != null){
            head.next = headN.next;
            headN.next = head.next == null ? null : head.next.next;
            head = head.next;
            headN = headN.next;
        }
        return res;
    }
}
