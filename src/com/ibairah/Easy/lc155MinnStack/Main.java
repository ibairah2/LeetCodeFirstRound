package com.ibairah.Easy.lc155MinnStack;

import java.util.Stack;

/**
 * Created by ibairah on 5/11/20.
 *
 * Design a stack that supports push, pop, top, and retrieving
 * the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 */
public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        System.out.println(minStack.toString());
        minStack.push(0);
        System.out.println(minStack.toString());
        minStack.push(-3);
        System.out.println(minStack.toString());
        minStack.getMin(); // return -3
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.toString());
        minStack.top();    // return 0
        System.out.println(minStack.top());
        minStack.getMin(); // return -2
        System.out.println( minStack.getMin());

        System.out.println( "----------------------------------------");

        MinstackNode nstack = new MinstackNode();
        nstack.push(-2);
        System.out.println(nstack.toString());
        nstack.push(0);
        System.out.println(nstack.toString());
        nstack.push(-3);
        System.out.println(nstack.toString());
        nstack.getMin(); // return -3
        System.out.println(nstack.getMin());
        nstack.pop();
        System.out.println(nstack.toString());
        nstack.top();    // return 0
        System.out.println(nstack.top());
        nstack.getMin(); // return -2
        System.out.println( nstack.getMin());

    }
}


class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
    }
    public void push(int x) {
        stack.push(x);
        // 如果最小stack为空，或者最小stack比x大，则push
        if (minstack.isEmpty() || minstack.peek() >= x) {
            minstack.push(x);
        }
    }
    public void pop() {
        // 如果当前被提出数值为最小数，则minstack同样也需要pop；
        if(stack.peek().equals(minstack.peek())){
            minstack.pop();
        }
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
       return minstack.peek();
    }
}

//  方法二 Node https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution

class MinstackNode{
    private class Node {
        int val;
        int min;
        Node next;

        // 创建两个node？
        private Node(int val, int min) {
            this(val, min, null);
        }

        // Node 里面有3个参数，（值，最小值，下一个Node地址）
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

   public void push(int x){
       if(head == null){
           head = new Node(x, x);
       }else{
           head = new Node(x, Math.min(x, head.min), head);
       }
   }

   public void pop(){
       head = head.next;
   }

   public int top(){
       return head.val;
   }

   public int getMin(){
       return head.min;
   }
}