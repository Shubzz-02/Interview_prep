package com.company.leetcode.march;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FindErrorNums {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionFEN().findErrorNums(new int[]{3, 2, 3, 4, 6, 5})));
    }
}

class SolutionFEN {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i))
                ans[1] = i;
            else if (map.get(i) == 2)
                ans[0] = i;
        }
        return ans;
    }
}
