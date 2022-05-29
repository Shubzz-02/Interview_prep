package com.company.leetcode.fnew.easy;

import java.util.Arrays;

public class Move_Zeroes_283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Move_Zeroes_283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void moveZeroes(int[] nums) {

        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[i] ^ nums[j] ^ (nums[j] = nums[i]);
                i++;
            }
        }
    }

}
