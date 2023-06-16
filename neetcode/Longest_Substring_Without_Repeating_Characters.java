package com.company.neetcode;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(new Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        int max = 1;
        int l = 0, r = 1;

        if (s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (r < s.length()) {

            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            max = Math.max(max, set.size());
            r++;
        }
        return max;
    }
}
