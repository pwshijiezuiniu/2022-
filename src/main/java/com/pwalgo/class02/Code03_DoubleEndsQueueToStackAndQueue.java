package com.pwalgo.class02;

public class Code03_DoubleEndsQueueToStackAndQueue {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.push(4);
        myStack.print();
        System.out.println("===================");
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.poll();
        myQueue.poll();
        myQueue.print();
    }
    public static class Node<T>{
        public T value;
        public Node<T> last;
        public Node<T> next;
        public Node(T value){
            this.value = value;
        }
    }
    public static class DoubleEndsQueue<T>{
        Node<T> head;
        Node<T> tail;
        public void addFromHead(T value){
            Node<T> cur = new Node<>(value);
            if(head == null){
                head = cur;
                tail = cur;
            }else {
                head.last =cur;
                cur.next = head;
                head = cur;
            }
        }
        public void addFromBottom(T value){
            Node<T> cur = new Node<>(value);
            if(head == null){
                head = cur;
                tail = cur;
            }else {
                tail.next =cur;
                cur.last = tail;
                tail = cur;
            }
        }
        public T popFromHead(){
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }
        public T popFromBottom(){
            if(head == null){
               return null;
            }
            Node<T> cur = tail;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                tail = tail.last;
                cur.last = null;
                tail.next = null;
            }
            return cur.value;
        }
        public boolean isEmpty(){
            return head == null;
        }
        public void print(){
            Node<T> cur = head;
            while(cur != null){
                System.out.print(cur.value+",");
                cur = cur.next;
            }
        }
    }
    public static class MyStack<T>{
        DoubleEndsQueue<T> doubleEndsQueue = new DoubleEndsQueue<>();
        public void push(T value){
            doubleEndsQueue.addFromHead(value);
        }
        public T pop(){
            if(doubleEndsQueue.isEmpty()){
                throw new RuntimeException("栈空了");
            }
            return doubleEndsQueue.popFromHead();
        }
        public boolean isEmpty(){
            return doubleEndsQueue.isEmpty();
        }
        public void print(){
            doubleEndsQueue.print();
        }
    }
    public static class MyQueue<T>{
        DoubleEndsQueue<T> doubleEndsQueue = new DoubleEndsQueue<>();
        public void push(T value){
            doubleEndsQueue.addFromHead(value);
        }
        public T poll(){
            if(doubleEndsQueue.isEmpty()){
                throw new RuntimeException("队列空了");
            }
            return doubleEndsQueue.popFromBottom();
        }
        public boolean isEmpty(){
            return doubleEndsQueue.isEmpty();
        }
        public void print(){
            doubleEndsQueue.print();
        }
    }
}
