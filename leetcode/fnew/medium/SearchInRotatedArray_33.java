package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class SearchInRotatedArray_33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(new SearchInRotatedArray_33().search(nums, 3));
    }

    public int search(int[] nums, int target) {
        return search2(nums, 0, nums.length - 1, target);
    }

    private int search2(int[] arr, int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[l] <= arr[mid]) {
            if (key >= arr[l] && key <= arr[mid])
                return search2(arr, l, mid - 1, key);
            return search2(arr, mid + 1, h, key);
        }
        if (key >= arr[mid] && key <= arr[h])
            return search2(arr, mid + 1, h, key);

        return search2(arr, l, mid - 1, key);
    }


}
