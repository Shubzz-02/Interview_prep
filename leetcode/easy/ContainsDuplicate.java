package com.company.leetcode.easy;

import java.util.Arrays;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(new SolutionCD().containsDuplicate(new int[]{1,2,3,4,5,6,7,8,9,5,4,6,3,2,1,5,5,4,8,8,4,8,5,6,4,4,}));
    }
}

class SolutionCD {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++)
            if (nums[i] == nums[i - 1])
                return true;
        return false;
    }
}
