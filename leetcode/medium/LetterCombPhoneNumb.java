package com.company.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombPhoneNumb {
    public static void main(String[] args) {
        System.out.println(new SolutionLCPN().letterCombinations("23"));
    }
}

class SolutionLCPN {
    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> list = new ArrayList<>();
        if (digits.length() != 0)
            backtrack("", digits, list, map);
        return list;
    }

    private void backtrack(String comb, String next_digits, List<String> list, Map<String, String> map) {
        if (next_digits.length() == 0)
            list.add(comb);
        else {
            String digit = next_digits.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(comb + letter, next_digits.substring(1), list, map);
            }
        }
    }
}
