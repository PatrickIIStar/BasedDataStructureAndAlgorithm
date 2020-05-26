package main.java.com.patrick.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/25 10:30
 * @declaration 0-1背包
 */
public class Knapsack {
    private final int[] weightOfGoods;
    private final int[] valueOfGoods;
    private final int capacity;
    private final int[][] dpTable;
    private final int[][] chooseTable;

    public Knapsack(int[] weightOfGoods, int[] valueOfGoods, int capacity) {
        this.weightOfGoods = weightOfGoods;
        this.valueOfGoods = valueOfGoods;
        this.capacity = capacity;
        this.dpTable = new int[weightOfGoods.length + 1][capacity + 1];
        this.chooseTable = new int[weightOfGoods.length + 1][capacity + 1];
    }

    public int getMaxValue() {
        return dpTable[weightOfGoods.length][capacity];
    }

    public List<Integer> getChooseMethod() {
        return getChooseMethod(weightOfGoods, chooseTable);
    }

    public void knapsack() {
        knapsack(weightOfGoods, valueOfGoods, capacity, dpTable, chooseTable);
    }

    private void knapsack(int[] weight, int[] val, int cap, int[][] dpTable, int[][] chooseTable) {
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= cap; j++) {
                if (weight[i - 1] > j) {
                    dpTable[i][j] = dpTable[i - 1][j];
                } else {
                    if (dpTable[i - 1][j] < val[i - 1] + dpTable[i - 1][j - weight[i - 1]]) {
                        dpTable[i][j] = val[i - 1] + dpTable[i - 1][j - weight[i - 1]];
                        chooseTable[i][j] = 1;
                    } else {
                        dpTable[i][j] = dpTable[i - 1][j];
                    }
                }
            }
        }

/*        System.out.println("最大价值为:" + dpTable[weight.length][cap]);
        System.out.print("方案为:");
        int i = val.length;
        int j = cap;
        while (i > 0 && j > 0) {
            if (chooseTable[i][j] != 0) {
                System.out.print("物品" + i + "\t");
                j -= weight[i - 1];
            }
            i--;
        }*/
    }

    private List<Integer> getChooseMethod(int[] weight, int[][] chooseTable) {
        List<Integer> goodsNum = new ArrayList<>();
        int i = chooseTable.length - 1;
        int j = chooseTable[i].length - 1;
        while (i > 0 && j > 0) {
            if (chooseTable[i][j] != 0) {
                goodsNum.add(i);
                j -= weight[i - 1];
            }
            i--;
        }
        return goodsNum;
    }

}
