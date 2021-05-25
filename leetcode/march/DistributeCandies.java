package com.company.leetcode.march;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DistributeCandies {
    public static void main(String[] args) {
        System.out.println(new SolutionDC().distributeCandies(new int[]{6, 6, 6, 6}));
    }
}


class SolutionDC {
//    public int distributeCandies(int[] candyType) {
//        int len = candyType.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : candyType) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        return Math.min(map.size(), len / 2);
//    }

    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        Set<Integer> set = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        return Math.min(set.size(), len / 2);
    }
}
