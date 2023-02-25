package com.company.leetcode.fnew.medium;

public class _560_Subarray_Sum_Equals_K {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(new _560_Subarray_Sum_Equals_K().subarraySum(nums, 3));
    }

    public int subarraySum(int[] nums, int k) {

        int[] prefix = new int[nums.length];
        int ps = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = ps + nums[i];
            ps = prefix[i];

        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefix[j];
                if (i > 0) {
                    sum -= prefix[i - 1];
                }

                if (sum == k) {
                    total++;
                }
            }
        }
        return total;
    }

}
