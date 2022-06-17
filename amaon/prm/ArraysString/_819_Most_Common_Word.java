package com.company.amaon.prm.ArraysString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class _819_Most_Common_Word {

    public static void main(String[] args) {
        String p = "Bob hit a it's ball, the hit BALL flew it's far after it's it was it's hit.";
        String[] banned = {"hit"};
        System.out.println(new _819_Most_Common_Word().mostCommonWord(p, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = Arrays.stream(banned).collect(Collectors.toSet());

        String[] p = paragraph.replaceAll("[.?,;!']", " ").toLowerCase(Locale.ROOT).trim()
                .split(" ");
        System.out.println(Arrays.toString(p));
        Map<String, Integer> map = new HashMap<>();

        for (String s : p) {
            if (!s.trim().isEmpty() && !set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        List<Entry<String, Integer>> mapList = new LinkedList<>(map.entrySet());
        mapList.sort(Entry.comparingByValue());
        return mapList.get(mapList.size() - 1).getKey();
    }
}
