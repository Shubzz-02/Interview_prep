package com.company.amaon.prm.ArraysString;

import java.util.HashMap;
import java.util.Map;

public class _1_Two_Sum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = new _1_Two_Sum().twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
