package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        System.out.println(
                new _378_Kth_Smallest_Element_in_a_Sorted_Matrix().kthSmallest(matrix, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int[] sorted = new int[matrix.length * matrix.length];
        int ind = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                sorted[ind++] = ints[j];
            }
        }

        Arrays.sort(sorted);
        return sorted[k - 1];
    }

}
