package com.company.leetcode.fnew.easy;

import java.util.HashMap;
import java.util.Map;

public class RTI_13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new RTI_13().romanToInt(s));
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};

        int no = 0;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == 'I') {
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'V')) {
                    no += map.get("IV");
                    i += 2;
                } else if (i + 1 < s.length() && (s.charAt(i + 1) == 'X')) {
                    no += map.get("IX");
                    i += 2;
                } else {
                    no += map.get("I");
                    i++;
                }
            } else if (ch == 'X') {
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'L')) {
                    no += map.get("XL");
                    i += 2;
                } else if (i + 1 < s.length() && (s.charAt(i + 1) == 'C')) {
                    no += map.get("XC");
                    i += 2;
                } else {
                    no += map.get("X");
                    i++;
                }
            } else if (ch == 'C') {
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'D')) {
                    no += map.get("CD");
                    i += 2;
                } else if (i + 1 < s.length() && (s.charAt(i + 1) == 'M')) {
                    no += map.get("CM");
                    i += 2;
                } else {
                    no += map.get("C");
                    i++;
                }
            } else {
                no += map.get(Character.toString(ch));
                i++;
            }
        }
        return no;
    }
}
