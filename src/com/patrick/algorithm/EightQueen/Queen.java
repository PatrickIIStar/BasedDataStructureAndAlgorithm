package com.patrick.algorithm.EightQueen;

import java.util.Arrays;
/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/23 17:03
 * @declaration
 */
public class Queen {
    private final int[] arr;
    private final int numOfQueen;
    private int count;

    public Queen(int n) {
        arr = new int[n];
        numOfQueen = n;
    }

    public void setQueen() {
        check(0);
    }

    public int getCount() {
        return count;
    }



    private void check(int n) {
        if (n >= numOfQueen) {
            showMethod();
            return;
        }
        for (int i = 0; i < numOfQueen; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void showMethod() {
        count++;
        System.out.println(Arrays.toString(arr));
    }
}
