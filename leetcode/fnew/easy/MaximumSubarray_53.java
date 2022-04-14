package com.company.leetcode.fnew.easy;

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubarray_53().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int msf = Integer.MIN_VALUE, meh = 0;

        for (int i = 0; i < len; i++) {
            meh += nums[i];
            if (msf < meh)
                msf = meh;
            if (meh < 0)
                meh = 0;
        }
        return msf;

    }
}
