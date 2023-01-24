package com.company.leetcode.fnew.medium;

import java.util.Stack;

public class _150_Evaluate_Reverse_Polish_Notation {

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new _150_Evaluate_Reverse_Polish_Notation().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")
                    || tokens[i].equals("/")) {
                String s = stack.pop();
                String f = stack.pop();
                if (tokens[i].equals("+")) {
                    stack.push(String.valueOf(Integer.parseInt(f) + Integer.parseInt(s)));
                } else if (tokens[i].equals("-")) {
                    stack.push(String.valueOf(Integer.parseInt(f) - Integer.parseInt(s)));
                } else if (tokens[i].equals("*")) {
                    stack.push(String.valueOf(Integer.parseInt(f) * Integer.parseInt(s)));
                } else {
                    stack.push(String.valueOf(Integer.parseInt(f) / Integer.parseInt(s)));
                }
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
