package com.pwalgo.base.class08;

import java.util.HashSet;
import java.util.Set;

public class Code02_TheminimumCommonancestor {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }
    public static class Info{
        public TreeNode minAncestor;
        boolean findA;
        boolean findB;
        public Info(TreeNode minAncestor, boolean findA, boolean  findB){
            this.minAncestor = minAncestor;
            this.findA = findA;
            this.findB = findB;
        }
    }
    public static TreeNode findminComAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p == root || q == root){
            return root;
        }
        if(p == q){
            return p;
        }
        return action(root, p, q).minAncestor;
    }
    public static Info action(TreeNode treeNode, TreeNode a, TreeNode b){
        if(treeNode == null){
            return new Info(null,false,false);
        }
        Info leftInfo = action(treeNode.left, a, b);
        Info rightInfo = action(treeNode.right, a, b);
        TreeNode minAncestor = null;
        boolean findA = leftInfo.findA || rightInfo.findA || treeNode == a;;
        boolean findB = leftInfo.findB || rightInfo.findB || treeNode == b;
        if(findA && findB){
            minAncestor = treeNode;
        }
        if(leftInfo.minAncestor != null){
            minAncestor = leftInfo.minAncestor;
        }
        if(rightInfo.minAncestor != null){
            minAncestor = rightInfo.minAncestor;
        }

        return new Info(minAncestor,findA,findB);
    }
}
