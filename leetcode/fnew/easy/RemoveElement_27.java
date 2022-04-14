package com.company.leetcode.fnew.easy;

import java.util.Arrays;

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int a = new RemoveElement_27().removeElement(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
