package com.company.leetcode.fnew.easy;

import java.util.Arrays;

public class _1480_Running_Sum_of_1d_Array {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new _1480_Running_Sum_of_1d_Array().runningSum(nums)));

    }

    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        int ssf = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i] + ssf;
            ssf = sum[i];
        }
        return sum;
    }

}
