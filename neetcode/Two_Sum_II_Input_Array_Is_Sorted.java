package com.company.neetcode;

public class Two_Sum_II_Input_Array_Is_Sorted {

    public static void main(String[] args) {

        int[] arr = new int[2];
    }

    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
