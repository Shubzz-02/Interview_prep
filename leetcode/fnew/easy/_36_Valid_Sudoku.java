package com.company.leetcode.fnew.easy;

import java.util.HashSet;
import java.util.Set;

public class _36_Valid_Sudoku {


    public static void main(String[] args) {

        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(new _36_Valid_Sudoku().isValidSudoku(board));

    }

    public boolean isValidSudoku(char[][] board) {

        Set<String> row = new HashSet<>();
        Set<String> col = new HashSet<>();
        Set<String> box = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int box_index = (i / 3) * 3 + j / 3;
                if (board[i][j] != '.') {
                    if (row.contains("row_" + i + "_" + board[i][j])
                            || col.contains("col_" + j + "_" + board[i][j])
                            || box.contains("box_" + box_index + "_" + board[i][j])) {
                        return false;
                    }

                    row.add("row_" + i + "_" + board[i][j]);
                    col.add("col_" + j + "_" + board[i][j]);
                    box.add("box_" + box_index + "_" + board[i][j]);
                }
            }
        }
        return true;
    }

}
