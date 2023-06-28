package com.company.neetcode;

public class Search_2D_Matrix {


    public static void main(String[] args) {

        int[][] a= {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        System.out.println(new Search_2D_Matrix().searchMatrix(a,3));

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0, j = (matrix[0].length * matrix.length) - 1;


        while (i <= j) {
            int mid = (i + j) >>> 1;

            int[] cord = new int[]{mid / matrix[0].length, mid % matrix[0].length};

            if (matrix[cord[0]][cord[1]] == target) {
                return true;
            } else if (matrix[cord[0]][cord[1]] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }


    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


}
