package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};

        System.out.println(
                Arrays.toString(
                        new _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(
                                nums,
                                8)));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBinarySearch(nums, target), rightBinarySearch(nums, target)};
    }


    public int leftBinarySearch(int[] nums, int target) {

        int ind = -1;

        int l = 0, r = nums.length - 1;
        while (l <= r) {

            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                ind = mid;
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ind;
    }

    public int rightBinarySearch(int[] nums, int target) {

        int ind = -1;

        int l = 0, r = nums.length - 1;

        while (l <= r) {

            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                ind = mid;
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ind;
    }

}
