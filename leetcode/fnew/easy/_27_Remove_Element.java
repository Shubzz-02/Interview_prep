package com.company.leetcode.fnew.easy;

public class _27_Remove_Element {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 5, 4, 5, 4, 5, 4, 5, 6, 7, 56, 8, 6, 7, 89, 78, 0, 5};

        int len = new _27_Remove_Element().removeElement(arr, 5);

        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }

    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
