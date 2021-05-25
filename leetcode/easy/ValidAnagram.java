package com.company.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(new SolutionVA().isAnagram("rat", "car"));
    }
}

class SolutionVA {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen)
            return false;

        for (int i = 0; i < slen; i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            smap.put(sch, smap.getOrDefault(sch, 0) + 1);
            tmap.put(tch, tmap.getOrDefault(tch, 0) + 1);
        }

        return smap.equals(tmap);
    }
}
