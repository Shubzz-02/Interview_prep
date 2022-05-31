package com.company.leetcode.fnew.medium;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters_3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(
                new Longest_Substring_Without_Repeating_Characters_3().lengthOfLongestSubstring(s));

    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (set.contains(ch)) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(ch);
            max = Math.max(max, (i - j) + 1);
        }
        return max;
    }
}
