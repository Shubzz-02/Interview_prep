package com.company.leetcode.misc;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(new SolutionMCO().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1, 0, 1}));
    }
}

class SolutionMCO {
    public int findMaxConsecutiveOnes(int[] nums) {
        //return Arrays.stream(nums).filter(i -> i == 1).toArray().length;
        int i = 0;
        int max = 0;
        int ct = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                ct++;
                if (ct > max)
                    max = ct;
            } else
                ct = 0;
            i++;
        }
        return max;
    }
}
