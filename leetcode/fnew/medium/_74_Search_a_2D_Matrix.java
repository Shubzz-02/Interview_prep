package com.company.leetcode.fnew.medium;

public class _74_Search_a_2D_Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(new _74_Search_a_2D_Matrix().searchMatrix(matrix, 8));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                if (binarySearch(matrix[i], target) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public int binarySearch(int[] arr, int target) {
        int ind = -1;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] == target) {
                ind = mid;
                break;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ind;
    }

}
