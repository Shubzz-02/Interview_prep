package com.company.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class BuddyString {
    public static void main(String[] args) {
        System.out.println(new SolutionBS().buddyStrings("ab", "ab"));
    }

}


class SolutionBS {
    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        if (s.equals(goal)) {
            for (Character c : s.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);
            for (Map.Entry<Character, Integer> entry : map.entrySet())
                if (entry.getValue() > 1)
                    return true;
            return false;
        } else {
            int f = -1, sec = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (f == -1) f = i;
                    else if (sec == -1) sec = i;
                    else return false;
                }
            }

            return (sec != -1 && s.charAt(f) == goal.charAt(sec) && s.charAt(sec) == goal.charAt(f));
        }

    }
}
