package com.company.leetcode.fnew.easy;

public class Remove_Duplicates_Sorted_Array_26 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int k = new Remove_Duplicates_Sorted_Array_26().removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
