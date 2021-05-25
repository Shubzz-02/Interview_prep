package com.company.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(new SolutionWP().wordPattern("abc", "b c a"));
    }
}

class SolutionWP {
    public boolean wordPattern(String pattern, String s) {
        Map<java.io.Serializable, Integer> map = new HashMap<>();
        int pl = pattern.length();
        String[] wp = s.trim().split(" ");
        int sl = wp.length;
        if (pl != sl)
            return false;
        for (int i = 0; i < pl; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(wp[i]))
                map.put(wp[i], i);
            if (!map.containsKey(c))
                map.put(c, i);

            if (!map.get(wp[i]).equals(map.get(c)))
                return false;
        }
        return true;
    }
}
