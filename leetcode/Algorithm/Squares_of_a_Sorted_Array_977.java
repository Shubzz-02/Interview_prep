package com.company.leetcode.Algorithm;

import java.util.Arrays;

public class Squares_of_a_Sorted_Array_977 {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(
                Arrays.toString(new Squares_of_a_Sorted_Array_977().sortedSquares(nums)));
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] ans = new int[nums.length];
        int end = nums.length - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[end] = (int) Math.pow(Math.abs(nums[left]), 2);
                end--;
                left++;
            } else {
                if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                    ans[end] = (int) Math.pow(Math.abs(nums[right]), 2);
                    end--;
                    right--;
                }
            }
        }
        return ans;
    }

}
