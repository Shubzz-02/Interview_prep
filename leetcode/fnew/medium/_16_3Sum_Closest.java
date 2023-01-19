package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _16_3Sum_Closest {

    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};

        System.out.println(new _16_3Sum_Closest().threeSumClosest(nums, -2));

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (r != nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(target - closest)) {
                    closest = sum;
                }
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
