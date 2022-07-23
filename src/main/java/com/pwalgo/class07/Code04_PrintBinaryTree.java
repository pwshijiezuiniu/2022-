package com.pwalgo.class07;

public class Code04_PrintBinaryTree {
    public static void main(String[] args) {
//        Node tree = new Node(3);
//        tree.left = new Node(4);
//        tree.left.left = new Node(7);
//        tree.left.right = new Node(9);
//        tree.right = new Node(10);
//        tree.right.left = new Node(0);
//        tree.right.right = new Node(1);
//        //System.out.println(func(tree));
//        printBinaryTree(tree);
printOT(3);
    }
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }
    public static void printBinaryTree(Node tree){
        if(tree == null){
            return;
        }
        printBinaryTree(tree,0,"H",17);
    }
    public static void printBinaryTree(Node node,int height,String to,int len){
        if(node == null){
            return;
        }
        printBinaryTree(node.right,height+1,"v",len);
        String val = String.valueOf(to+node.value+to);
        int lenLeft = (len - val.length()) >> 1;
        int lenright = len - lenLeft - val.length();
        val = getSpace(lenLeft) + val + getSpace(lenright);
        System.out.println(getSpace(height*len) + val);
        printBinaryTree(node.left,height+1,"v",len);
    }
    public static String getSpace(int i){
        StringBuilder stringBuilder = new StringBuilder();
        while(i-- > 0){
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
    public static void printOT(int N){
        printOT(1,N,true);
    }
    public static void printOT(int i, int N,boolean O){
        if(i > N){
            return;
        }
        printOT(i+1 ,N ,true);
        System.out.print(O?"凹":"凸");
        printOT(i+1,N,false);
    }
}
