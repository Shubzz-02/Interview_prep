package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_Group_Anagrams {

    public static void main(String[] args) {

        String[] strs =  new String[]{"eat","tea","tan","ate","nat","bat"};

        List<List<String>> l = new _49_Group_Anagrams().groupAnagrams(strs);

        l.forEach(System.out::println);

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
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
