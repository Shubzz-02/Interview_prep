package com.company.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class AmazValidSudoku {
    public static void main(String[] args) {
//        Short a = 365;
//        System.out.println(a++);
//        System.out.println("Welcome".contains("welcome"));
//
//        Set<String> set = new HashSet<>();
//        set.add("awdawdaw");
//        set.add("dawdaw");
//        set.add("dwadawd");
//        set.add("vsfse");
//        set.add("csca");
//        set.add("grgse");
//        set.add("bdffdgb");
//        set.add("vxdv");
//        set.add("hmhnvgcb");
//        set.add("fserfdfxdvx");
//        set.add("vdghfgdf");
//        set.add("sfdrgbv");
//        set.add("thghhfd");
//        set.add("sefrghftgfdsd");
//        System.out.println(set.toString());
        System.out.println(new SolutionAVS().isValidSudoku(new char[][]{
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


class SolutionAVS {
    public boolean isValidSudoku(char[][] board) {
        Set<String> col_set = new HashSet<>();
        Set<String> box_set = new HashSet<>();
        Set<String> row_set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int bi = (i / 3) * 3 + j / 3;
                if (board[i][j] != '.') {
                    int n = Integer.parseInt(String.valueOf(board[i][j]));
                    if (!row_set.add(i+""+n) ||
                            !col_set.add(j+""+n) ||
                            !box_set.add(bi + "" + n)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

/*
[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
[["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
*/