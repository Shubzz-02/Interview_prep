package com.company.leetcode.fnew.medium;

import java.util.Arrays;

/**
 * @author Shubzz-02
 */
public class FindFirstLastElem_34 {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new FindFirstLastElem_34().searchRange(arr, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBinarySearch(nums, target), rightBinarySearch(nums, target)};
    }

    private int leftBinarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        int res = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (arr[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else if (target < arr[mid]) {
                high = mid - 1;
            }
        }
        return res;
    }

    private int rightBinarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        int res = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (arr[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else if (target < arr[mid]) {
                high = mid - 1;
            }
        }
        return res;
    }


}
