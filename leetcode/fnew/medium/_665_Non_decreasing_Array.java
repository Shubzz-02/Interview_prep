package com.company.leetcode.fnew.medium;

public class _665_Non_decreasing_Array {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3};
        System.out.println(new _665_Non_decreasing_Array().checkPossibility(arr));

    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i - 1]) {
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                    count++;
                } else {
                    nums[i] = nums[i - 1];
                    count++;
                }
            }
        }
        return count <= 1;
    }

}
