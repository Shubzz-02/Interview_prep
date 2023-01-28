package com.company.leetcode.fnew.medium;

public class _153_Find_Minimum_in_Rotated_Sorted_Array {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new _153_Find_Minimum_in_Rotated_Sorted_Array().findMin(nums));
    }

    public int findMin(int[] nums) {

        int l = 0, r = nums.length - 1;
        int min = nums[0];
        while (l <= r) {
            int mid = (l + r) >>> 1;
            min = Math.min(nums[mid], min);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return min;
    }


}
