package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class Next_Permutation_31 {

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new Next_Permutation_31().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            nums[i] = nums[j] ^ nums[i] ^ (nums[j] = nums[i]);
        }
        i = i + 1;
        int j = nums.length - 1;
        while (i < j) {
            nums[i] = nums[j] ^ nums[i] ^ (nums[j] = nums[i]);
            i++;
            j--;
        }
    }
}
