package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _128_Longest_Consecutive_Sequence {

    public static void main(String[] args) {

        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new _128_Longest_Consecutive_Sequence().longestConsecutive(nums));

    }

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longCons = 1;
        int currCons = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currCons += 1;
                } else {
                    longCons = Math.max(longCons, currCons);
                    currCons = 1;
                }
            }
        }
        return Math.max(longCons, currCons);
    }

}
