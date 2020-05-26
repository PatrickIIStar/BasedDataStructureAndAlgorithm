package main.java.com.patrick.leetcode;

import java.util.*;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/19 10:17
 * @declaration  两个数组的交集
 */
public class Intersection {
    // 相同数字只输出一次
    public static int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num:nums1){
            set.add(num);
        }
        for (int num:nums2){
            if (set.contains(num)){
                if (!list.contains(num)){
                    list.add(num);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // 返回所有相交的值(同一个值相交几次输出几次)
    public static int[] intersect(int[] nums1, int[] nums2){
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num:nums1){
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        for (int num:nums2){
            if (map.containsKey(num)){
                map.put(num,map.get(num)-1);
                if (map.get(num)>=0){
                    list.add(num);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,1,3};
        int[] b = {2,2,1};
        int[] c = intersect(a,b);
        for (int value : c) {
            System.out.print(value + "\t");
        }
    }
}
