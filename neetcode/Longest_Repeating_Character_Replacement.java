package com.company.neetcode;

import java.util.HashMap;
import java.util.Map;

public class Longest_Repeating_Character_Replacement {

    public static void main(String[] args) {
        String s = "ABAB";
        System.out.println(new Longest_Repeating_Character_Replacement().characterReplacement(s, 2));
    }

    public int characterReplacement(String s, int k) {


        Map<Character, Integer> map = new HashMap<>();

        int l = 0, r = 0;

        int maxLen = 0;

        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            int maxChar = 0;
            for (int i = 'A'; i <= 'Z'; i++) {
                if (map.containsKey((char) i)) {
                    maxChar = Math.max(maxChar, map.get((char) i));
                }
            }
            if (((r - l) + 1) - maxChar <= k) {
                maxLen = Math.max((r - l) + 1, maxLen);
                r++;
            } else {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
                r++;
            }
        }
        return maxLen;
    }
}
