package main.java.com.patrick.leetcode;

import java.util.Stack;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/20 16:45
 * @declaration  用栈实现队列
 */
public class MyQueue {
    public Stack<Integer> stack;
    public Stack<Integer> tempStack;

    public MyQueue(){
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x){
        while (!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        stack.push(x);
        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }

    public int pop(){
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public boolean empty(){
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

    }
}
