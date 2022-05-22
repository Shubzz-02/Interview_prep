package com.company.leetcode.fnew.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shubzz-02
 */
public class Valid_Sudoku_36 {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new Valid_Sudoku_36().isValidSudoku(arr));
    }

    public boolean isValidSudoku(char[][] board) {

        Set<String> row_set = new HashSet<>();
        Set<String> col_set = new HashSet<>();
        Set<String> box_set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int bi = (i / 3) * 3 + j / 3;

                if (board[i][j] != '.') {
                    int n = Integer.parseInt(String.valueOf(board[i][j]));
                    if (!row_set.add(i + " " + n) || !col_set.add(j + " " + n)
                            || !box_set.add(bi + " " + n)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
