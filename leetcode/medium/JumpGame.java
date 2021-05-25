package com.company.leetcode.medium;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new SolutionJG().canJump(new int[]{2, 3, 1, 1, 4}));
    }
}


class SolutionJG {
    public boolean canJump(int[] nums) {
        int lastpos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastpos)
                lastpos = i;
        }
        return lastpos == 0;
    }
}
