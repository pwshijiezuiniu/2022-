package com.pwalgo.base.class06;


public class Code01_GetLinkedListMIddle {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public Node getMidOrUpMid(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        Node s = head.next;
        Node q = head.next.next;
        while(q.next != null || q.next.next != null){
            s = s.next;
            q = q.next.next;
        }
        return s;
    }
    public Node getMidOrDownMid(Node head){
        if(head ==null || head.next ==null){
            return head;
        }
        Node s = head.next;
        Node q = head.next;
        while(q.next != null || q.next.next != null){
            s = s.next;
            q = q.next.next;
        }
        return s;
    }
}
