package com.cracking.coding.interview.leetcode.topinterview.medium.mix;


/**
 * Medium
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    boolean[][] visited;


    public boolean exist(char[][] board, String word) {

        int rowsLen = board.length;
        int colsLen = board[0].length;

        visited = new boolean[rowsLen][colsLen];
        int i, j;

        char wordFirstChar = word.charAt(0);

        for (i = 0; i < rowsLen; i++) {
            for (j = 0; j < colsLen; j++) {
                if (wordFirstChar != board[i][j]) {
                    continue;
                }
                //locate word
                if (locateWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean locateWord(char[][] board, String word, int i, int j, int index) {

        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (locateWord(board, word, i - 1, j, index + 1) ||
                locateWord(board, word, i + 1, j, index + 1) ||
                locateWord(board, word, i, j - 1, index + 1) ||
                locateWord(board, word, i, j + 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;

        return false;
    }
}
