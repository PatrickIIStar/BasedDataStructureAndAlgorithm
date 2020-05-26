package main.java.com.patrick.leetcode;

import java.util.Stack;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/20 17:42
 * @declaration 类似逆波兰表达式，计算网球比赛得分
 */
public class CalPoints {
    public static int calPoints(String[] ops){
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String item:ops){
            if ("C".equals(item)){
                stack.pop();
            }else if ("D".equals(item)){
                stack.push(stack.peek()*2);
            }else if("+".equals(item)){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second);
                stack.push(first);
                stack.push(first+second);
            }else {
                stack.push(Integer.parseInt(item));
            }
        }
        while (stack.size()>0){
            res+=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] tmp = {"5","-2","4","C","D","9","+","+"};
        System.out.println(CalPoints.calPoints(tmp));
    }
}
