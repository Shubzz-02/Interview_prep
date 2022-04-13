package com.company.leetcode.fnew.easy;

import java.util.Stack;

public class Valid_Parentheses_20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;
                switch (ch) {
                    case '}':
                        if (!(stack.pop() == '{')) return false;
                        break;
                    case ')':
                        if (!(stack.pop() == '(')) return false;
                        break;
                    case ']':
                        if (!(stack.pop() == '[')) return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
