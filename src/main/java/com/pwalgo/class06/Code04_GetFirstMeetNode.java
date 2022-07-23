package com.pwalgo.class06;

public class Code04_GetFirstMeetNode {
    public static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
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

    public static Node getFirstMeetNode(Node head1,Node head2){
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop1 ==loop2){
            return getByNoloop(head1,head2);
        }
        if(loop1 != null && loop2 == loop1){
            return getByLoopOne(head1,head2,loop1);
        }
        if(loop1 != null && loop2 !=null && loop1 != loop2){
            return getByLoopTwice(loop1,loop2);
        }
        return null;
    }
    public static Node getByNoloop(Node headA,Node headB){
        int n = 0;
        Node cur1 = headA;
        while(cur1.next != null){
            cur1 = cur1.next;
            n++;
        }
        Node cur2 = headB;
        while(cur2.next !=null){
            cur2 = cur2.next;
            n--;
        }
        if(cur1 != cur2){
            return null;
        }
        Node tem1 = n > 0 ? headA : headB;
        Node tem2 = tem1 ==headA? headB:headA;
        n = Math.abs(n);
        while(n-- > 0){
            tem1 = tem1.next;
        }
        while(tem1 !=tem2){
            tem1 = tem1.next;
            tem2 = tem2.next;
        }
        return tem1;
    }
    public static Node getByLoopOne(Node head1,Node head2,Node headB){
        int n = 0;
        Node cur1 = head1;
        while(cur1 != headB){
            cur1 = cur1.next;
            n++;
        }
        Node  cur2 = head2;
        while(cur2 != headB){
            cur2 = cur2.next;
            n--;
        }

        Node tem1 = n > 0 ? head1 : head2;
        Node tem2 = tem1 ==head1? head2:head1;
        n = Math.abs(n);
        while(n-- > 0){
            tem1 = tem1.next;
        }
        while(tem1 !=tem2){
            tem1 = tem1.next;
            tem2 = tem2.next;
        }
        return tem1;
    }
    public static Node getByLoopTwice(Node loop1,Node loop2){
        Node next = loop1.next;
        while(next != loop2){
            if(next == loop1){
                return null;
            }
            next = next.next;
        }
        return loop1;
    }
}
