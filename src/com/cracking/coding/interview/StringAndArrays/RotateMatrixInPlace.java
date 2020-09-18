package com.cracking.coding.interview.StringAndArrays;

/**
 * Easy
 * Approach transpose matrix by swapping row amd cols
 * Them swap columns to get result.
 */
public class RotateMatrixInPlace {
    public void rotate(int[][] matrix) {


        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rowCnt = matrix.length;
        int colCnt = matrix[0].length;

        int i, j, swap;

        for (i = 0; i < rowCnt; i++) {
            for (j = i; j < colCnt; j++) {
                swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }

        //swap columns
        int colSmall = 0, colLarge = colCnt - 1;
        while (colSmall < colLarge) {
            for (int row = 0; row < rowCnt; row++) {
                swap = matrix[row][colSmall];
                matrix[row][colSmall] = matrix[row][colLarge];
                matrix[row][colLarge] = swap;
            }
            colSmall++;
            colLarge--;
        }
    }
}
