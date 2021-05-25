package com.company.leetcode.medium;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionFLP().searchRange(new int[]{5, 7, 7, 8, 8, 10,}, 8)));
    }
}

class SolutionFLP {
    public int[] searchRange(int[] nums, int target) {
        //System.out.println(Arrays.binarySearch(nums, target));
        int[] res = new int[]{-1, -1};
        int i = 0;
        int l = nums.length - 1;
        while (i <= l) {
            if (nums[i] == target) {
                res[0] = i;
            } else {
                i++;
            }
            if (nums[l] == target) {
                res[1] = l;
            } else {
                l--;
            }
            if (res[0] >= 0 && res[1] >= 0)
                break;
        }
        return res;
    }
}
