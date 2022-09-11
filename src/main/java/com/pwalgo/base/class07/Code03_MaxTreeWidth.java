package com.pwalgo.base.class07;

import java.util.*;

public class Code03_MaxTreeWidth {
    public static void main(String[] args) {
        Node tree = new Node(3);
        tree.left = new Node(4);
        tree.left.left = new Node(7);
        tree.left.right = new Node(9);
        tree.right = new Node(10);
        tree.right.left = new Node(0);
        tree.right.right = new Node(1);
        //System.out.println(func(tree));

    }
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int val){
            this.value = val;
            left = null;
            right = null;
        }
    }

    public static int getMaxWidth(Node tree){
        if(tree == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node,Integer> levelMap = new HashMap<>();
        int level = 1;
        int count = 0;
        int max = 0;
        queue.add(tree);
        levelMap.put(tree,1);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int curNodelevel = levelMap.get(cur);
            if(cur.left != null){
                queue.add(cur.left);
                levelMap.put(cur.left,curNodelevel+1);
            }
            if(cur.right !=null){
                queue.add(cur.right);
                levelMap.put(cur.right,curNodelevel+1);
            }
            if(level == curNodelevel){
                count++;
            }else {
                max = Math.max(max,count);
                count = 1;
                level++;
            }
        }
        max = Math.max(max,count);
        return max;
    }
    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        // key 在 哪一层，value
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1; // 当前你正在统计哪一层的宽度
        int curLevelNodes = 0; // 当前层curLevel层，宽度目前是多少
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }
    public static int func(Node tree){
        if(tree == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        Node curlast = tree;
        Node nextlast = null;
        int max = 0;
        int count = 0;
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(cur.left != null){
                queue.add(cur.left);
                nextlast = cur.left;
            }
            if(cur.right !=null){
                queue.add(cur.right);
                nextlast = cur.right;
            }
            count++;
            if(cur == curlast){
                max = Math.max(max,count);
                curlast = nextlast;
                count = 0;
            }
        }
        return max;

    }
}
