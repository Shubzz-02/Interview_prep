package com.company.amaon.prm.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        String digits = "";
        new _17_Letter_Combinations_of_a_Phone_Number().letterCombinations(digits)
                .forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {


        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0, map, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String digits, int i, Map<Character, String> map,
            StringBuilder stringBuilder, List<String> ans) {
        if (i == digits.length()) {
            ans.add(stringBuilder.toString());
            return;
        }

        String curr = map.get(digits.charAt(i));
        for (int j = 0; j < curr.length(); j++) {
            stringBuilder.append(curr.charAt(j));
            backtrack(digits, i + 1, map, stringBuilder, ans);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

}
