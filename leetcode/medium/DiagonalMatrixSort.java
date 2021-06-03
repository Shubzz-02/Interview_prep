package com.company.leetcode.medium;

import java.util.Arrays;

public class DiagonalMatrixSort {
    public static void main(String[] args) {
        int[][] ans = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };
        ans = new SolutionDMS().diagonalSort(ans);
        for (int[] i : ans)
            System.out.println(Arrays.toString(i));
    }
}


class SolutionDMS {
    public int[][] diagonalSort(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        for (int col = 0; col < r; col++) {
            sort(mat, 0, col, r, c);
        }
        for (int row = 1; row < c; row++)
            sort(mat, row, 0, r, c);
        return mat;
    }

    private void sort(int[][] mat, int row, int col, int r, int c) {
        int[] count = new int[101];
        int m = row, n = col;
        while (m < r && n < c) {
            count[mat[m][n]]++;
            m++;
            n++;
        }

        m = row;
        n = col;

        for (int i = 0; i < 101; i++) {
            while (count[i]-- > 0) {
                mat[r][c] = i;
                r++;
                c++;
            }
        }
    }
}
