package com.company.neetcode;

import java.util.*;

public class Group_Anagrams {


    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new Group_Anagrams().groupAnagrams(strs).forEach(
                System.out::println
        );


    }

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {

            char[] arr = s.toCharArray();

            Arrays.sort(arr);
            String key = Arrays.toString(arr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }


}
