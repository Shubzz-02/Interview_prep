package com.company.leetcode.fnew.easy;

import java.util.HashMap;
import java.util.Map;

public class _242_Valid_Anagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(new _242_Valid_Anagram().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();

        for (Character ch : t.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch,0)+1);
        }

        return map.equals(map2);
    }

}
