package com.company.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(new SolutionVS().isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}

class SolutionVS {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] column = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];
        Arrays.fill(rows, new HashMap<Integer,Integer>());
        Arrays.fill(column, new HashMap<Integer,Integer>());
        Arrays.fill(box, new HashMap<Integer,Integer>());

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int bi = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    column[j].put(n, column[j].getOrDefault(n, 0) + 1);
                    box[bi].put(n, box[bi].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || column[j].get(n) > 1 || box[bi].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}

//
//class SolutionVS {
//    public boolean isValidSudoku(char[][] board) {
//        Map<Integer, Integer>[] rows = new HashMap[9];
//        Map<Integer, Integer>[] columns = new HashMap[9];
//        Map<Integer, Integer>[] boxes = new HashMap[9];
//        Arrays.fill(rows, new HashMap<>());
//        Arrays.fill(columns, new HashMap<>());
//        Arrays.fill(boxes, new HashMap<>());
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                char ch = board[i][j];
//                if (ch != '.') {
//                    int n = (int)ch;
//                    int bi = (i / 3) * 3 + j / 3;
//                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
//                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
//                    boxes[bi].put(n, boxes[bi].getOrDefault(n, 0) + 1);
//
//                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[bi].get(n) > 1)
//                        return false;
//                }
//            }
//        }
//        return true;
//    }
//}
/*
{{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'{{
 */

/*
{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }
 */
