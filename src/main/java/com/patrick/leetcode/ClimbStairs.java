package main.java.com.patrick.leetcode;


/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/17 18:27
 * @declaration
 */
public class ClimbStairs {
    public static int climbStairs(int n){
        /*
        int first = 1;
        int second = 2;
        int res = 0;
        if(n==1||n==2){
            return n==1?1:2;
        }
        for (int i = 3; i <= n ; i++) {
            res += first+second;
            first = second;
            second = res;
        }
        return res;

         */
        int[] nums = new int[n+1];
        if(n==1||n==2){
            return n==1?1:2;
        }
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i-1]+nums[i-2];
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        climbStairs(100000000);
        System.out.println(System.currentTimeMillis()-s);
    }
}
