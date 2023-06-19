package com.company.neetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Minimum_Window_Substring {

    public static void main(String[] args) {

        System.out.println(new Minimum_Window_Substring().minWindow("cabwefgewcwaefgcf", "cae"));
    }

    public String minWindow(String s, String t) {

        int l = 0, r = 0;

        if (t.length() > s.length()) {
            return "";
        }

        String ans = "";
        Map<Character, Integer> tMap = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        i -> 1,
                        Integer::sum
                ));

        int have = 0;
        int min = Integer.MAX_VALUE;

        Map<Character, Integer> sMap = new HashMap<>();
        while (r < s.length()) {
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            if (tMap.containsKey(s.charAt(r))) {
                if (Objects.equals(sMap.get(s.charAt(r)), tMap.get(s.charAt(r)))) {
                    have++;
                }
            }
            while (have == tMap.size()) {
                if ((r - l) + 1 < min) {
                    ans = s.substring(l, r + 1);
                    min = (r - l) + 1;
                }
                if (tMap.containsKey(s.charAt(l)) && sMap.get(s.charAt(l)) <= tMap.get(s.charAt(l))) {
                    have--;
                }
                sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }

        return ans;
    }


    public String minWindowBF(String s, String t) {


        if (t.length() > s.length())
            return "";
        Map<Character, Integer> tMap = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        i -> 1,
                        Integer::sum
                ));

        int need = tMap.size();


        int min = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> sMap = new HashMap<>();

            int have = 0;
            for (int j = i; j < s.length(); j++) {

                sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);

                if (tMap.containsKey(s.charAt(j))) {
                    if (Objects.equals(sMap.get(s.charAt(j)), tMap.get(s.charAt(j)))) {
                        have++;
                    }
                }

                if ((j - i) + 1 >= min) {
                    break;
                }

                if (have == need && (j - i) + 1 < min) {
                    ans = s.substring(i, j + 1);
                    min = (j - i) + 1;
                    break;
                }

//                if (tMap.containsKey(s.charAt(j))) {
//                    sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
//                }
//
//                if (isMapEqual(tMap, sMap)) {
//                    if ((j - i) + 1 < min) {
//                        ans = s.substring(i, j + 1);
//                        min = (j - i) + 1;
//                        break;
//                    }
//                }
            }
        }

        return ans;

    }

    private boolean isMapEqual(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {

        int total = 0;
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character key = entry.getKey();

            if (sMap.containsKey(key) && entry.getValue() <= sMap.get(key)) {
                total++;
            }
        }
        return total == tMap.size();
    }
}
