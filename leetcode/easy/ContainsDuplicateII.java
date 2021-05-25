package com.company.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(new SolutionCDII().containsNearbyDuplicate(new int[]{99, 99}, 2));
    }
}

class SolutionCDII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
        List<List<Integer>> values = new ArrayList<>(map.values());
        for (List<Integer> v : values) {
            len = v.size();
            if (len == 0 || len == 1)
                continue;
            for (int i = 1; i < len; i++) {
                if (Math.abs(v.get(i) - v.get(i - 1)) <= k)
                    return true;
            }
        }
        return false;
    }
}
