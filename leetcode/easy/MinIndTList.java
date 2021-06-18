package com.company.leetcode.easy;

import java.util.*;

public class MinIndTList {
    public static void main(String[] args) {
        String[] a = new SolutionMIL().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"});
        System.out.println(Arrays.toString(a));
    }
}

class SolutionMIL {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++)
            for (int j = 0; j < list2.length; j++)
                if (list1[i].equals(list2[j]))
                    map.computeIfAbsent(i + j, o -> new ArrayList<>()).add(list1[i]);

        int min = Integer.MAX_VALUE;
        for (int key : map.keySet())
            min = Math.min(key, min);

        return map.get(min).toArray(new String[0]);
    }
}
