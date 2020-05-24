package com.patrick.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/20 17:17
 * @declaration 下一个更大元素
 */
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        for (int value : nums2) {
            while (!stack.isEmpty() && value > stack.peek()) {
                map.put(stack.peek(), value);
                stack.pop();
            }
            stack.push(value);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums2 = {2,3,5,1,0,7};
        int[] nums1 = {2,3,5};
        int[] res = NextGreaterElement.nextGreaterElement(nums1,nums2);
        for (int val:res){
            System.out.println(val);
        }
    }
}
