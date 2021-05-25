package com.company.leetcode.easy;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 0, 4, 5, 0, 6, 7, 0, 8, 9, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 6, 0};
        new SolutionMZ().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}


class SolutionMZ {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < len) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    } else
                        j++;
                }
            }
        }
    }
}


/*
1 2 0 4 5 0 6 5 4 0 5 8 0 6 5 0 6 8 0 6 8
1 2 4 5 6 0 0
 */
