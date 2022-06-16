package com.company.amaon.prm.ArraysString;

import java.util.Arrays;

public class _48_Rotate_Image {

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        new _48_Rotate_Image().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = i + 1; j < c; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i] ^ (matrix[j][i] = matrix[i][j]);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r / c; j++) {
                matrix[i][j] =
                        matrix[i][r - j - 1] ^ matrix[i][j] ^ (matrix[i][r - j - 1] = matrix[i][j]);
            }
        }
    }

}
