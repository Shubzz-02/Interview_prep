package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _167_Two_Sum_II_Input_Array_Is_Sorted {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};

        System.out.println(
                Arrays.toString(new _167_Two_Sum_II_Input_Array_Is_Sorted().twoSum(numbers, 9)));

    }

    public int[] twoSum(int[] numbers, int target) {

        int[] arr = new int[2];
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }

}
