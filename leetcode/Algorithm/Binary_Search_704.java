package com.company.leetcode.Algorithm;

import java.util.Arrays;

public class Binary_Search_704 {

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(new Binary_Search_704().search(arr, 13));
    }

    public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length-1;

            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                }
            }
            return -1;
    }
}
