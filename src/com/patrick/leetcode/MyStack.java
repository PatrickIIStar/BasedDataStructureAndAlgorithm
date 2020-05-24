package com.patrick.leetcode;

import java.util.*;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/20 16:21
 * @declaration  用队列实现栈
 */
public class MyStack {
    public List<Integer> queue;

    public MyStack(){
        queue = new ArrayList<>();
    }

    public void push(int x){
        queue.add(x);
    }
    public int pop(){
        int top = queue.get(queue.size()-1);
        queue.remove(queue.size()-1);
        return top;
    }
    public int top(){
        return queue.get(queue.size()-1);
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}

class MyStack1{
    public Queue<Integer> queue;
    public MyStack1(){
        queue = new LinkedList<>();
    }

    public void push(int x){
        int size = queue.size();
        queue.add(x);
        while (size>0){
            queue.add(queue.remove());
            size--;
        }
    }

    public int pop(){
        return queue.remove();
    }

    public int top(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {

    }
}
