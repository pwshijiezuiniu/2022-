package com.pwalgo.base.class10;

import java.util.*;

public class Code01_IsSameStudent {
    public static class Student{
        public String pid;
        public String bilid;
        public String gitid;
        public Student(String pid,String bilid,String gitid){
            this.bilid = bilid;
            this.pid = pid;
            this.gitid = gitid;
        }
    }
    public static class Node<V>{
        V values;
        public Node(V values){
            this.values = values;
        }
    }
    public static class UnionSearch<V>{
        private Map<V,Node<V>> nodes = new HashMap<>();
        private Map<Node<V>,Node<V>> parent = new HashMap<>();
        private Map<Node<V>,Integer> size = new HashMap<>();
        public Integer size(){
            return size.size();
        }
        public UnionSearch(List<V> list){
            for (V it: list
            ) {
                Node<V> node = new Node<V>(it);
                nodes.put(it,node);
                parent.put(node,node);
                size.put(node,1);
            }
        }
        public Node<V> findFather(V value){
            Node cur = nodes.get(value);
            Stack<Node<V>> stack = new Stack<Node<V>>();
            while(cur != parent.get(cur)){
                stack.push(cur);
                cur = parent.get(cur);
            }
            while(!stack.isEmpty()){
                parent.put(stack.pop(),cur);
            }
            return cur;
        }
        public void union(V t2, V t1){
            if(!nodes.containsKey(t1) || !nodes.containsKey(t1)){
                return;
            }
            Node<V> node1 = findFather(t1);
            Node<V> node2 = findFather(t2);
            if(node1 != node2){
                int size1 = size.get(node1);
                int size2 = size.get(node2);
                Node<V> big = size1 >= size2 ? node1 : node2;
                Node<V> small = big == node1 ? node2 : node1;
                parent.put(small,big);
                size.put(big,size.get(big)+size.get(small));
                size.remove(small);
            }

        }
        public boolean isSameSet(V t1,V t2){
            if(!nodes.containsKey(t1) || !nodes.containsKey(t1)){
                return false;
            }
            return findFather(t1) == findFather(t2);
        }
    }

    public static void main(String[] args) {
        Student student = new Student("123", "甲", "xyz");
//        Student student1 = new Student("123", "甲", "xyz");
       // Student student2 = new Student("123", "甲", "xyz");
        Student student1 = new Student("124", "乙", "qyz");
        Student student2 = new Student("423", "丁", "xyzq");
        Student student3 = new Student("567", "甲", "xyz");
        Student student4 = new Student("1239", "张", "xio");
        Student student5 = new Student("567", "吴", "xyzq");
        Student student6 = new Student("789", "郑", "poi");
        Map<String,Student> pid = new HashMap<>();
        Map<String,Student> bilid = new HashMap<>();
        Map<String,Student> gitid = new HashMap<>();

        List<Student> lists = Arrays.asList(student,student1,student2,student3,student4,student5,student6);
        UnionSearch<Student> search = new UnionSearch<Student>(lists);
//        search.union(student,student1);
//        search.union(student,student2);
//        search.union(student,student3);
//        search.union(student,student4);
//        search.union(student,student5);
//        search.union(student,student6);
//        System.out.println(search.size());
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(search.size()+",i="+i);
            Student s = lists.get(i);
            System.out.println(s+","+pid.get(s.pid));
            if(!pid.containsKey(s.pid)){
                pid.put(s.pid,s);
            }else {
                search.union(s,pid.get(s.pid));
            }
            if(!bilid.containsKey(s.bilid)){
                bilid.put(s.bilid,s);
            }else {
                search.union(s,bilid.get(s.bilid));
            }
            if(!gitid.containsKey(s.gitid)){
                gitid.put(s.gitid,s);
            }else {
                search.union(s,gitid.get(s.gitid));
            }
        }
        System.out.println(search.size());
    }
     
}
