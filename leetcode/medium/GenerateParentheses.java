package com.company.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new SolutionGP().generateParenthesis(3));
    }
}


class SolutionGP {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String curr, int open, int close, int n) {
        if (curr.length() == n * 2) {
            list.add(curr);
            return;
        }
        if (open < n) {
            backtrack(list, curr + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(list, curr + ")", open, close + 1, n);
        }
    }
}
