package com.company.leetcode.fnew.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class _451_Sort_Characters_By_Frequency {

    public static void main(String[] args) {

        String s = "tree";
        System.out.println(new _451_Sort_Characters_By_Frequency().frequencySort(s));

    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> sortedMap = map.entrySet().stream().sorted(
                        Entry.comparingByValue((o1, o2) -> o2 - o1))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));
        StringBuilder sb = new StringBuilder();
        for (Entry<Character, Integer> entry : sortedMap.entrySet()) {
            sb.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }
        return sb.toString();
    }

}
