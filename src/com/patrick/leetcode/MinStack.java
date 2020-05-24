package com.patrick.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/20 16:04
 * @declaration  设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 */
public class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else if (x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        if (Objects.equals(minStack.peek(), stack.peek())) {
            stack.pop();
            minStack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}

