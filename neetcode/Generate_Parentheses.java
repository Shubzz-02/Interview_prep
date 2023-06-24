package com.company.neetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

    public static void main(String[] args) {
        System.out.println(new Generate_Parentheses().generateParenthesis(3 ));

    }

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        backtrack(n, 0, 0, list, new StringBuilder());
        return list;
    }

    private void backtrack(int n, int open, int close, List<String> list, StringBuilder sb) {

        if (sb.length() == n * 2) {
            list.add(String.valueOf(sb));
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(n, open + 1, close, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(n, open, close + 1, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
