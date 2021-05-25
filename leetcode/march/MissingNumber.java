package com.company.leetcode.march;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(new SolutionMN().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}


class SolutionMN {
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        for (int i : nums)
            sum -= i;
        return sum;
    }
}
