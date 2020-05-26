package main.java.com.patrick.leetcode;


/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/25 18:05
 * @declaration 动态规划，最大子序列和
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = Math.max(nums[i], res[i - 1] + nums[i]);
        }
        int max = res[0];
        for (int i = 1; i < res.length; i++) {
            if (max < res[i]) {
                max = res[i];
            }
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (res >= 0) {
                res = res + num;
            } else {
                res = num;
            }
            max = Math.max(max, res);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(nums));
    }
}
