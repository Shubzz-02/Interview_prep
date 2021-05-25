package com.company.leetcode.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SumOfUnique {
    public static void main(String[] args) {
        System.out.println(new SolutionSOU().sumOfUnique(new int[]{1,2,3,4,5}));
    }
}

class SolutionSOU {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        AtomicInteger sum = new AtomicInteger();
        map.forEach((k, v) -> {
            if (v == 1) {
                sum.addAndGet(k);
            }
        });
        return sum.intValue();
    }
}
