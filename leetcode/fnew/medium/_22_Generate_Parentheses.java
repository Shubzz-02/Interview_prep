package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {

    public static void main(String[] args) {

        List<String> list ;
        list = new _22_Generate_Parentheses().generateParenthesis(3);
        System.out.println(list);
        System.out.println(list.size());

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == n * 2) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(ans, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(ans, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
