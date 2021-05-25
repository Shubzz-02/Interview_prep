package com.company.leetcode.misc;

import java.util.HashMap;
import java.util.Map;

public class NAndDouble {
    public static void main(String[] args) {
        System.out.println(new SolutionNAD().checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }
}

class SolutionNAD {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0) + 1);
        for (int a : arr) {
            if (a == 0 && map.get(0) >= 2) {
                return true;
            } else if (a != 0 && map.containsKey(a * 2))
                return true;
        }
        return false;
    }
}
