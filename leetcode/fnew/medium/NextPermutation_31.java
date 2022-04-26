package com.company.leetcode.fnew.medium;

import com.company.etc.Array;

import java.util.Arrays;

public class NextPermutation_31 {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3};
        new NextPermutation_31().nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i+1] <= nums[i])
            i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            nums[i] = nums[i] ^ nums[j] ^ (nums[j] = nums[i]);
        }
        i = i + 1;
        int j = nums.length - 1;
        while (i < j) {
            nums[i] = nums[i] ^ nums[j] ^ (nums[j] = nums[i]);
            i++;
            j--;
        }
    }
}
