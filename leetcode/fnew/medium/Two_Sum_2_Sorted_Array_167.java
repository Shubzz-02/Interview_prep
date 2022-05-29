package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class Two_Sum_2_Sorted_Array_167 {

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};

        System.out.println(Arrays.toString(new Two_Sum_2_Sorted_Array_167().twoSum(num,9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
