package com.company.leetcode.fnew.medium;

import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest_16 {
    public static void main(String[] args) {
        int[] num = new int[]{-1, 2, 1, -4};
        int res = new ThreeSumClosest_16().threeSumClosest(num, 1);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return closest;
    }
}
