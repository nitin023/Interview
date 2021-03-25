package com.cracking.coding.interview.leetcode.topinterview.medium.mix;


/**
 * Medium
 * https://leetcode.com/problems/game-of-life/
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) {
            return;
        }
        updateBoardViaRules(board);
    }

    /**
     * O(N*M) Time Complexity
     * O(N*M) Space Complexity
     *
     * @param board to update
     */
    private void updateBoardViaRules(int[][] board) {

        int[][] boardListCopy = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boardListCopy[i][j] = board[i][j];
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = getAllDirectionsValueViaRule(i, j, boardListCopy);
            }
        }
    }

    private int getAllDirectionsValueViaRule(int i, int j, int[][] board) {
        int currentVal = board[i][j];
        if (currentVal == 0) {
            return applyDealCellRules(i, j, board);
        } else {
            return applyLiveCellRules(i, j, board);
        }
    }

    private int applyDealCellRules(int i, int j, int[][] board) {
        int countOfActiveCells = getActiveCellsCount(i, j, board);

        if (countOfActiveCells == 3) {
            return 1;
        }
        return 0;

    }

    private int applyLiveCellRules(int i, int j, int[][] board) {
        int countOfActiveCells = getActiveCellsCount(i, j, board);

        if (countOfActiveCells < 2)
            return 0;


        if (countOfActiveCells == 2 || countOfActiveCells == 3)
            return 1;

        return 0;

    }

    private int getActiveCellsCount(int i, int j, int[][] board) {
        int countOfActiveCells = 0;
        int colCount = board[i].length;
        int rowCount = board.length;
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1)
            countOfActiveCells++;

        if (i - 1 >= 0 && board[i - 1][j] == 1)
            countOfActiveCells++;

        if (i - 1 >= 0 && j + 1 < colCount && board[i - 1][j + 1] == 1)
            countOfActiveCells++;

        if (j - 1 >= 0 && board[i][j - 1] == 1)
            countOfActiveCells++;

        if (j + 1 < colCount && board[i][j + 1] == 1)
            countOfActiveCells++;

        if (i + 1 < rowCount && j - 1 >= 0 && board[i + 1][j - 1] == 1)
            countOfActiveCells++;

        if (i + 1 < rowCount && board[i + 1][j] == 1)
            countOfActiveCells++;

        if (i + 1 < rowCount && j + 1 < colCount && board[i + 1][j + 1] == 1)
            countOfActiveCells++;

        return countOfActiveCells;
    }

    /**
     * One more solution exists
     * It says you don't make additional copy of the board
     * as it is expensive operation in memory
     * so you mark a dead cell with -1 and a live cell with 2
     * now process board accordingly
     * and at last step update all -1 and 2
     * @param board
     */
    public void gameOfLifeConstantSpace(int[][] board) {

    }
}
