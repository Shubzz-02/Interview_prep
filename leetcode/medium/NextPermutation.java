package com.company.leetcode.medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] n = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        new SolutionNP().nextPermutation(n);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
        System.out.println(Arrays.toString(n));
    }
}


/*
 0 1 2 3 4 5 6 7 8
 1 5 8 4 7 6 5 3 1

 len = 9
 */
class SolutionNP {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, len);
    }

    private void reverse(int[] nums, int start, int len) {
        int i = start, j = len - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
