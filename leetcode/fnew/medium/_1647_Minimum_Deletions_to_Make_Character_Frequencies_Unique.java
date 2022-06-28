package com.company.leetcode.fnew.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique {

    public static void main(String[] args) {
        String s = "aaabbbcc";
        System.out.println(
                new _1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique().minDeletions(s));

    }

    public int minDeletions(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Set<Integer> freq = new HashSet<>();
        int total = 0;

        for (Character ch : map.keySet()) {
            int chFreq = map.get(ch);
            if (freq.contains(chFreq)) {
                while (chFreq != 0) {
                    if (!freq.contains(chFreq)) {
                        freq.add(chFreq);
                        break;
                    }
                    total++;
                    chFreq--;
                }
            } else {
                freq.add(chFreq);
            }
        }
        return total;
    }

}
