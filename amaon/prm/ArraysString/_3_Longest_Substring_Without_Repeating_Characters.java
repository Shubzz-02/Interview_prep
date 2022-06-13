package com.company.amaon.prm.ArraysString;

import java.util.HashSet;
import java.util.Set;

public class _3_Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(
                new _3_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring(
                        s));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        int max = 0, j = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(ch);
            max = Math.max(max, (i - j) + 1);
        }
        return max;
    }

}
