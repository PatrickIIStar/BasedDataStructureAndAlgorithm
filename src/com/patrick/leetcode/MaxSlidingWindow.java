package com.patrick.leetcode;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/21 9:48
 * @declaration 滑动窗口的最大值
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            res[i] = getMax(nums, i, j);
        }
        return res;
    }

    public static int getMax(int[] num, int i, int j) {
        int max = num[i];
        for (int k = i + 1; k <= j; k++) {
            if (max < num[k]) {
                max = num[k];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] num = maxSlidingWindow(a, k);
        for (int val : num) {
            System.out.print(val + "\t");
        }
    }
}
