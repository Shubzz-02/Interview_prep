package com.company.etc;

import java.util.Stack;

public class ParentBalance {
    public static void main(String[] args) {
        String s = "))((";
        System.out.println(minRemove(s));
    }

    public static String minRemove(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> positions = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                positions.pop();
            } else if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                stack.add(s.charAt(i));
                positions.add(i);
            }
        }

        while (!positions.isEmpty()) {
            int p = positions.pop();
            s = s.substring(0, p) + s.substring(p + 1);
        }

        return s;
    }
}
