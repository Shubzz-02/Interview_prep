package com.company.neetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutation_in_String {


    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(new Permutation_in_String().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {

        int l = 0, r = s1.length() - 1;

        if (r >= s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = s1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        c -> 1,
                        Integer::sum
                ));

        Map<Character, Integer> s2Map = s2.substring(l, r).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        c -> 1,
                        Integer::sum
                ));

        while (r < s2.length()) {
            s2Map.entrySet().removeIf(entry -> entry.getValue() == 0);
            s2Map.put(s2.charAt(r), s2Map.getOrDefault(s2.charAt(r), 0) + 1);
            if (s1Map.equals(s2Map)) {
                return true;
            } else {
                s2Map.put(s2.charAt(l), s2Map.get(s2.charAt(l)) - 1);
            }
            l++;
            r++;
        }

        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s1Length > s2Length) {
            return false;
        }

        Map<Character, Long> s1Map = s1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> s2Map = IntStream.range(0, s1Length)
                .mapToObj(s2::charAt)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (s1Map.equals(s2Map)) {
            return true;
        }

        for (int i = s1Length; i < s2Length; i++) {
            char removeChar = s2.charAt(i - s1Length);
            s2Map.computeIfPresent(removeChar, (key, value) -> value == 1 ? null : value - 1);
            char addChar = s2.charAt(i);
            s2Map.merge(addChar, 1L, Long::sum);

                if (s1Map.equals(s2Map)) {
                return true;
            }
        }

        return false;
    }


}
