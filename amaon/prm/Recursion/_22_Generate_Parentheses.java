package com.company.amaon.prm.Recursion;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {

    public static void main(String[] args) {
        int n = 3;
        new _22_Generate_Parentheses().generateParenthesis(n).forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder stringBuilder, int open, int close,
            int max) {
        if (stringBuilder.length() == max * 2) {
            ans.add(stringBuilder.toString());
            return;
        }

        if (open < max) {
            stringBuilder.append("(");
            backtrack(ans, stringBuilder, open + 1, close, max);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (close < open) {
            stringBuilder.append(")");
            backtrack(ans, stringBuilder, open, close + 1, max);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

}
