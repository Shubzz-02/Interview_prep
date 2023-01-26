package com.company.leetcode.fnew.easy;

public class _704_Binary_Search {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.out.println(new _704_Binary_Search().search(arr, 5));
    }

    public int search(int[] nums, int target) {
        int ind = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                ind = mid;
                break;
            } else if (target < nums[mid]) {
                r = mid - 1;

            } else {
                l = mid + 1;
            }
        }

        return ind;
    }

}
