package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions
 * Medium
 * O(m*n)
 */
public class SurroundedRegions {

    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        //check first and last col
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O')
                flipUsingDFS(board, i, 1);
            if (board[i][cols - 1] == 'O')
                flipUsingDFS(board, i, cols - 2);
        }

        // check first row and last row
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O')
                flipUsingDFS(board, 1, i);
            if (board[rows - 1][i] == 'O')
                flipUsingDFS(board, rows - 2, i);
        }
        // flip O to X, '*' to 'O',
        // skip the boundary
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == '*')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private  void flipUsingDFS(char[][] board, int i, int j) {

        if (i <= 0 || j <= 0 || i >= board.length - 1 || j >= board[0].length - 1 || board[i][j] == 'X')
            return;
        if (board[i][j] == '*')
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';

        flipUsingDFS(board, i + 1, j);
        flipUsingDFS(board, i - 1, j);
        flipUsingDFS(board, i, j + 1);
        flipUsingDFS(board, i, j - 1);
    }
}
