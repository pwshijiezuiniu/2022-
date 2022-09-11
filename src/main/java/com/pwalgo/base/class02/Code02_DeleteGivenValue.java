package com.pwalgo.base.class02;

public class Code02_DeleteGivenValue {
    public static void main(String[] args) {
        Node list = generateRandomLinkedList(20, 3);
        print(list);
        Node node = deleteValue(list, 0);
        System.out.println();
        print(node);

    }
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node generateRandomLinkedList(int maxSize,int maxValue){
        int len = (int) (Math.random()*(maxSize + 1));
        Node head = new Node((int) (Math.random()*(maxValue + 1)));
        Node pre = head;
        while(--len > 0){
            Node next = new Node((int) (Math.random()*(maxValue + 1)));
            pre.next = next;
            pre = pre.next;
        }
        return head;
    }
    public static void print(Node head){
        while(head != null){
            System.out.print(head.value+",");
            head = head.next;
        }
    }
    public static Node deleteValue(Node head,int value){
        while(head !=null){
            if(head.value != value){
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while(cur != null){
            if(cur.value == value) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
