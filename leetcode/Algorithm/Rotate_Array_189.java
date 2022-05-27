package com.company.leetcode.Algorithm;

import java.util.Arrays;

public class Rotate_Array_189 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Rotate_Array_189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[(i + k) % (nums.length)] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }

}
