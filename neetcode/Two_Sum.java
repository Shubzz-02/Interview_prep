package com.company.neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};

        System.out.println(Arrays.toString(new Two_Sum().twoSum(nums, 9)));

    }


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int no = target - nums[i];
            if (map.containsKey(no)) {
                return new int[]{map.get(no), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
