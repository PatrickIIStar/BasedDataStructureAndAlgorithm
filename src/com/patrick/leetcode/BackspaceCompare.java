package com.patrick.leetcode;

import java.util.Stack;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/20 18:08
 * @declaration 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符
 * 示例
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 */
public class BackspaceCompare {
    public static boolean backspaceCompare(String S, String T){
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!('#'==(S.charAt(i)))){
                stack1.push(S.charAt(i));
            }else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (!('#'==(T.charAt(i)))){
                stack2.push(T.charAt(i));
            }else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        return stack1.equals(stack2);
    }

    public static void main(String[] args) {
        String S = "#ac";
        String T = "ac";
        System.out.println(BackspaceCompare.backspaceCompare(S,T));
    }
}
