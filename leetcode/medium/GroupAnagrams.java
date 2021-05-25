package com.company.leetcode.medium;

import java.util.*;

public class GroupAnagrams {
}

class SolutionGA {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            ans.computeIfAbsent(key, i -> new ArrayList<>()).add(s);
        }
        Math.pow(1, 2);
        return new ArrayList<>(ans.values());
    }
}
