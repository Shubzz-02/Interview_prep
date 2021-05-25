package com.company.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new SolutionLSWRC().lengthOfLongestSubstring("abcabcda"));
    }
}

class SolutionLSWRC {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
