package com.cracking.coding.interview.StringAndArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZero {

    /**
     * O(M+N) Space complexity
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int i, j;

        Set<Integer> rowsToZero = new HashSet();
        Set<Integer> colsToZero = new HashSet();

        for (i = 0; i < rowCount; i++) {
            if (!rowsToZero.contains(i)) {
                for (j = 0; j < colCount; j++) {
                    if (matrix[i][j] == 0) {
                        rowsToZero.add(i);
                        colsToZero.add(j);
                    }
                }
            }
        }

        if (!rowsToZero.isEmpty()) {
            for (int index : rowsToZero) {
                for (j = 0; j < colCount; j++) {
                    matrix[index][j] = 0;
                }
            }
        }

        if (!colsToZero.isEmpty()) {
            for (int index : colsToZero) {
                for (j = 0; j < rowCount; j++) {
                    matrix[j][index] = 0;
                }
            }
        }
    }

    /**
     * Best Solution constant space solution O(1)
     * Approach
     *
     * find if the starting row/col have a zero if true set boolean variables to true
     * iterate second row/col and if an elem is fount to be 0 then set arr[i][0] = 0 and arr[j][0] = 0
     * that means start col/row of that elem to 0
     * later on iterate all the matrix to find such elem and finally set all elem to zeroes where this is true
     */
    private void setZeroesInConstantSpaceComplexity(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        int rowCnt = matrix.length;
        int colCnt = matrix[0].length;

        for (int i = 0; i < colCnt; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < rowCnt; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 1; i < rowCnt; i++) {
            for (int j = 1; j < colCnt; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rowCnt; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        for (int i = 1; i < colCnt; i++) {
            if (matrix[0][i] == 0) {
                nullifyCol(matrix, i);
            }
        }

        if (firstRowHasZero) {
            nullifyRow(matrix, 0);
        }
        if (firstColHasZero) {
            nullifyCol(matrix, 0);
        }
    }

    private void nullifyRow(int[][] matrix, int index) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[index][i] = 0;
        }
    }

    private void nullifyCol(int[][] matrix, int index) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][index] = 0;
        }
    }
}
