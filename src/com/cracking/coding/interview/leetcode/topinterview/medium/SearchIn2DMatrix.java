package com.cracking.coding.interview.leetcode.topinterview.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 */
public class SearchIn2DMatrix {

    //O(M+N)
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (col > -1 && row < matrix.length) {

            if (target == matrix[row][col]) {
                return true;
            }

            if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }


        return false;
    }

    //O(NLogM)
    public boolean searchMatrixUsingBinarySearch(int[][] matrix, int target) {

        int rows = matrix.length;

        for (int i = 0; i < rows; i++) {

            int firstElemCurrRow = matrix[i][0];
            int lastElemCurrRow = matrix[i][matrix[i].length - 1];

            if (firstElemCurrRow <= target && target <= lastElemCurrRow) {
                int index = Arrays.binarySearch(matrix[i], target);
                if (index > -1) {
                    return true;
                }
            }
        }

        return false;
    }
}
