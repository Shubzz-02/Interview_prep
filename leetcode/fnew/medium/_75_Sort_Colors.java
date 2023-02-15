package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _75_Sort_Colors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new _75_Sort_Colors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    nums[i] = nums[i] ^ nums[j] ^ (nums[j] = nums[i]);
                }
            }
        }
    }

}
