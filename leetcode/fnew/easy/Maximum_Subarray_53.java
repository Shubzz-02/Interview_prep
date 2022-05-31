package com.company.leetcode.fnew.easy;

public class Maximum_Subarray_53 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Maximum_Subarray_53().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }
}
