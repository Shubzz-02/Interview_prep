package com.company.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class SpecialEquivStrings {
    public static void main(String[] args) {
        System.out.println(new SolutionSES().numSpecialEquivGroups(new String[]{"aa","bb","ab","ba"}));
    }
}

class SolutionSES {
    public int numSpecialEquivGroups(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> oMap1 = createMap(words[i], 0);
            Map<Character, Integer> eMap1 = createMap(words[i], 1);
            int ct = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() == words[j].length()) {
                    Map<Character, Integer> oMap2 = createMap(words[j], 0);
                    if (oMap1.equals(oMap2) && eMap1.equals(createMap(words[j], 1))) {
                        ct++;
                        words[j] = "";
                    }
                }
            }
            words[i] = "";
            max = Math.max(max, ct);
        }
        return max;
    }

    private Map<Character, Integer> createMap(String word, int i) {
        Map<Character, Integer> map = new HashMap<>();
        for (; i < word.length(); i += 2) {
            char c = word.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

}
