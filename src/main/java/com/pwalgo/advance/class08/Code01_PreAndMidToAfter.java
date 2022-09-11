package com.pwalgo.advance.class08;

public class Code01_PreAndMidToAfter{
    public static void main(String[] args) {
        int [] pre = new int[]{1,2,4,5,7};
        int [] mid = new int[]{4,2,5,1,7};
        int[] func = func(pre, mid);
        for (int i : func) {
            System.out.println(i);
        }
    }
    //给你先序和中序遍历的数组生成后续遍历数组
    public static int[] func(int []pre,int []mid){
        if(pre.length != mid.length){
            return null;
        }
        int N = pre.length-1;
        int [] post = new int[pre.length];
        process(post,0,N
                ,pre,0,N,
        mid,0,N);
        return post;
    }
    public static void process(int[] post,int postleft,int postright
            ,int []pre,int preleft,int preright,
                                int []mid,int midleft,int midright){
        if(postleft > postright){
            return;
        }
        if(preleft == preright){
            post[postleft] = pre[preleft];
            return;
        }
        post[postright] = pre[preleft];
        int i = midleft;
        for (; i <midright ; i++) {
           if(mid[i] == pre[preleft]){
               break;
           }
        }
        int left = i-midleft - 1;
        //int right = midright - i;
        process(post,postleft,postleft+left,pre,preleft+1,preleft+left+1,mid,midleft,i-1);
        process(post,postleft+left+1,postright-1,pre,preleft+left+2,preright,mid,i+1,midright);

    }
}
