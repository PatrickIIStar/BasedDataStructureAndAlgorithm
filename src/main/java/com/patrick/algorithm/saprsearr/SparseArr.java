package main.java.com.patrick.algorithm.saprsearr;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/6 9:46
 */
public class SparseArr {
    public static int[][] sparseArr(int[][] old) {
        int sum = 0;
        int count = 0;
        for (int[] rows : old) {
            for (int data : rows) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        // 存放
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = old.length;
        sparseArr[0][1] = old.length;
        sparseArr[0][2] = sum;
        for (int i = 0; i < old.length; i++) {
            for (int j = 0; j < old[i].length; j++) {
                if (old[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = old[i][j];
                }
            }
        }

        // 复原
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] ne = new int[row][col];
        for (int i = 1; i < sparseArr.length; i++) {
            row = sparseArr[i][0];
            col = sparseArr[i][1];
            int val = sparseArr[i][2];
            ne[row][col] = val;
        }
        return ne;
    }
}
