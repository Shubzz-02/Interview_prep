package com.company.leetcode.fnew.easy;

import java.util.Stack;

public class _20_Valid_Parentheses {

    public static void main(String[] args) {

        String s = "(]";

        System.out.println(new _20_Valid_Parentheses().isValid(s));
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (s.charAt(i) == ')' && stack.peek() == '('
                        || s.charAt(i) == ']' && stack.peek() == '['
                        || s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

}
