package com.company.amaon.prm.ArraysString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_Group_Anagrams {

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = new _49_Group_Anagrams().groupAnagrams(str);
        for (List<String> l : list) {
            System.out.println(l);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();

        int[] arr = new int[26];
        for (String str : strs) {
            Arrays.fill(arr, 0);
            for (int j = 0; j < str.length(); j++) {
                arr[(str.charAt(j) - 'a')]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(arr[i]);
                sb.append("*");
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
