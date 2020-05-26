package main.java.com.patrick.algorithm;

import main.java.com.patrick.algorithm.dynamicprogramming.Activity;
import main.java.com.patrick.algorithm.dynamicprogramming.ActivitySelect;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/23 17:17
 * @declaration 只用于测试 algorithm部分
 */
public class AlgorithmTest {
    public static void main(String[] args) {
        /*
        // 八皇后
        Queen queen = new Queen(8);
        queen.setQueen();
        System.out.println(queen.getCount());

         */
//***************************************************************************

        /*
        // 稀疏矩阵
        int row = FileUtil.getRowsCount();
        int col = FileUtil.getColCount();
        int[][] old = new int[row][col];
        FileUtil.readFile(old);

        for (int[] rows : old) {
            for (int data : rows) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        int[][] ne = SparseArr.sparseArr(old);
        System.out.println(ne.length);
        for (int[] rows : ne) {
            for (int data : rows) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        */


//***********************************************************************************************
/*
         //后缀表达式(逆波兰表达式)
        String s = "10 10 + 10 X 10 - 15 /";
        ArrayList<String> list = PolandNotation.toPolandList(s);
        System.out.println(list);
        int res = PolandNotation.getPolandResult(list);
        System.out.println(res);
//********************************************
        String m = "5*(5-2)+1*5";
        ArrayList<String> ls = PolandNotation.toList(m);
        System.out.println(ls);
        ArrayList<String> list = PolandNotation.getPolandExpression(ls);
        System.out.println(list);
        System.out.println(PolandNotation.getPolandResult(list));
 */

//******************************************************************************************************
/*
//        排序
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length);
        }

        int[] ar = {4,6,8,5,9};
        long atime = System.currentTimeMillis();
//        Sort.insertSort(arr);   // 插入
//        Sort.selectSort(arr);   // 选择
//        Sort.bubbleSort(arr);   // 冒泡
//        Sort.radixSort(arr);   // 基数排序
//        Sort.insertShellSort(arr); // 插入希尔排序
//        Sort.quickSort(ar, 0, ar.length - 1);  // 快排
//        Sort.mergeSort(arr,0,arr.length-1);  // 归并
        Sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis() - atime);
*/

///********************************************************************************************

/*
//      查找
        int[] arr = {0,1,2,3,4};
        int res = (Search.binarySearch0(arr,0,arr.length-1,6));
//        ArrayList<Integer> arrayList = Search.binary(arr,1);
        int res1 = Search.binarySearch(arr,5);
//        int res2 = Search.fibSearch(arr,4);
//        System.out.println(res2);
        System.out.println(res1);

 */
      /*
      // 汉诺塔
        HanoiTower hanoiTower = HanoiTower.getInstance();
        hanoiTower.hanoiTower(2);
        System.out.println(hanoiTower.getMoveCount());

*/
        /*
        // 0-1背包
        int[] weight = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int cap = 4;
        Knapsack knapsack = new Knapsack(weight,val,cap);
        knapsack.knapsack();
        System.out.println(knapsack.getMaxValue());
        System.out.println(knapsack.getChooseMethod());
        */

        Activity[] activities = {
                new Activity(0, 0, 0),
                new Activity(1, 4, 5),
                new Activity(3, 5, 1),
                new Activity(0, 6, 8),
                new Activity(4, 7, 4),
                new Activity(3, 8, 6),
                new Activity(5, 9, 3),
                new Activity(6, 10, 2),
                new Activity(8, 11, 4),
                new Activity(0, 11, 1)};

        ActivitySelect activitySelect = new ActivitySelect(activities);
        activitySelect.activitySelect();
        System.out.println(activitySelect.maxValue());
        System.out.println(activitySelect.selectionOfMaxValue());

    }
}
