package com.patrick.leetcode;

import java.util.Arrays;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/16 17:45
 * @declaration  小于n的所有素数，暴力法超时
 */

public class CountPrimes {
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= (int)Math.sqrt(n); i += 1) {
            if (isPrime[i]) {
                for (int j = 2; i * j < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(countPrimes(15));
    }
}
