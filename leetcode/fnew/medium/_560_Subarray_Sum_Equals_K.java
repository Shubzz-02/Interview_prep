package com.company.leetcode.fnew.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _560_Subarray_Sum_Equals_K {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(new _560_Subarray_Sum_Equals_K().subarraySum(nums, 3));
    }

    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}
