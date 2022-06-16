package com.company.amaon.prm.ArraysString;

import java.util.HashMap;
import java.util.Map;

public class _76_Minimum_Window_Substring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new _76_Minimum_Window_Substring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {

        if (s.equals("") || t.equals("")) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0;
        String ans = "";
        int total = t.length();
        int sub = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        while (r < s.length()) {
            while (r < s.length() && sub < total) {
                char ch = s.charAt(r);
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                if (tMap.containsKey(ch) && sMap.get(ch) <= tMap.get(ch)) {
                    sub++;
                }
                r++;
            }

            while (l < r && sub == total) {
                if (ans.isEmpty() || (r - l) < ans.length()) {
                    ans = s.substring(l, r);
                }
                char ch = s.charAt(l);
                if (sMap.get(ch) == 1) {
                    sMap.remove(ch);
                } else {
                    sMap.put(ch, sMap.get(ch) - 1);
                }

                if (tMap.containsKey(ch)) {
                    if (!sMap.containsKey(ch)) {
                        sub--;
                    } else if (sMap.get(ch) < tMap.get(ch)) {
                        sub--;
                    }
                }
                l++;
            }
        }
        return ans;
    }
}
