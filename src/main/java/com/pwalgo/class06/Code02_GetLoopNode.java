package com.pwalgo.class06;

public class Code02_GetLoopNode {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node s = head.next;
        Node q = head.next.next;
        while(s != q){
            if(q == null ||q.next == null){
                return  null;
            }
            q = q.next.next;
            s = s.next;
        }
        Node cur = head;
        while(cur != s){
            cur = cur.next;
            s = s.next;
        }
        return s;
    }
}
