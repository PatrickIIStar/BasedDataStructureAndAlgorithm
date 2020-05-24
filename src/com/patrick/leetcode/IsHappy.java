package com.patrick.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/16 17:07
 * @declaration   快乐数
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1
 * 也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果不是快乐数，最终会陷入循环，while结束的条件是要么结果是1，要么陷入循环
 */
public class IsHappy {
    public static boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        int r;
        while (n!=1&&!nums.contains(n)) {
            nums.add(n);
            int res = 0;
            int length = ("" + n).length();
            for (int i = 0, temp = 1; i < length; i++, temp *= 10) {
                r = n / temp % 10;
                res += (int) Math.pow(r, 2);
            }
            n = res;
        }
        System.out.println(nums);
        return n == 1;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(10));
    }
}
