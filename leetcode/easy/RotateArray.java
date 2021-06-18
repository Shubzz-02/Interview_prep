package com.company.leetcode.easy;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new SolutionRA().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}

class SolutionRA {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }


    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            nums[start] = nums[start] ^ nums[end] ^ (nums[end] = nums[start]);
            start++;
            end--;
        }
    }
}
