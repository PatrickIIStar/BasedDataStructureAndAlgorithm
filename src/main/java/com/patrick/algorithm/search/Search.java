package main.java.com.patrick.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/11 15:52
 */
public class Search {
    public static int maxSize = 20;

    /**
     * @param arr    目标数组
     * @param target 目标值
     * @return int
     * @declaration 线性查找方法查找数组中的某个值
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i])
                return i;
        }
        return -1;
    }


    // 非递归
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if (target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }
        while (left <= right) {
//            int mid = (left + right) / 2;
//            int mid = left + (right-left)/2;
            // 插值查找
            int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
//        return left;
        return -1;
    }

    //递归
    public static int binarySearch0(int[] arr, int left, int right, int target) {
        int mid = (left + right) >>> 1;
        if (left <= right) {
            if (arr[mid] < target) {
                return binarySearch0(arr, mid + 1, right, target);
            } else if (arr[mid] > target) {
                return binarySearch0(arr, left, mid - 1, target);
            } else {
                return mid;
            }
        }
//        return left;
        return -1;
    }

    //非递归查找所有相同元素下标
    public static ArrayList<Integer> binary(int[] arr, int target) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
            else {
                int temp = mid - 1;
                while (temp >= 0 && arr[temp] == target) {
                    temp--;
                }
                while (temp <= mid - 1) {
                    arrayList.add(temp);
                    temp++;
                }
                arrayList.add(mid);
                temp = mid + 1;
                while (temp < arr.length && arr[temp] == target) {
                    arrayList.add(temp);
                    temp++;
                }
                return arrayList;
            }
        }
        //arrayList.add(left);
        return arrayList;
    }

    public static int fibSearch(int[] arr, int target) {
        int[] fib = fib();
        int k = 0;
        int mid;
        int left = 0;
        int right = arr.length - 1;

        while (right > fib[k] - 1) {
            k++;
        }

        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        while (left <= right) {
            mid = left + fib[k] - 1;
            if (target < temp[mid]) {
                k = k - 1;
                right = mid - 1;
            } else if (target > temp[mid]) {
                k = k - 2;
                left = mid + 1;
            } else
                return Math.min(mid, arr.length - 1);
        }
        return -1;
    }

    public static int[] fib() {
        int[] fi = new int[maxSize];
        fi[0] = 1;
        fi[1] = 1;
        for (int i = 2; i < fi.length; i++) {
            fi[i] = fi[i - 1] + fi[i - 2];
        }
        return fi;
    }
}
