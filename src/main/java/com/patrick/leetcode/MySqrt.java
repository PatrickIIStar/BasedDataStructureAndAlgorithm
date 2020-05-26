package main.java.com.patrick.leetcode;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/17 17:49
 * @declaration  不用Math.sqrt()实现求得整数的平方根(取整数部分)
 */
public class MySqrt {
    public static int mySqrt(int x){
        /*   牛顿迭代法
        double k = 1.0;
        while (Math.abs(k-x/k)>0.000000001){
            k = (k+x/k)/2;
        }
        return (int)k;

         */

        // 二分查找
        int l=0;
        int r = x;
        int res = 0;
        while (l<=r){
            int mid = l+(r-l)/2;
            if ((long)mid*mid<=x){
                res = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1000));
    }
}
