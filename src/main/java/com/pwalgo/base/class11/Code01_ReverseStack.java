package com.pwalgo.base.class11;

import java.util.Stack;

public class Code01_ReverseStack {
    public static class StackTool<T>{
        public T findLast(Stack<T> stack){
            T cur = stack.pop();
            if(stack.isEmpty()){
                return cur;
            }
            T temp = findLast(stack);
            stack.push(cur);
            return temp;
        }
        public void reverse(Stack<T> stack){
            if(stack.isEmpty()){
                return;
            }
            T cur = findLast(stack);
            reverse(stack);
            stack.push(cur);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        StackTool<Integer> stackTool = new StackTool<>();
        stackTool.reverse(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

}
