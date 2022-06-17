package com.company.amaon.prm.ArraysString;

import java.util.Stack;

public class _20_Valid_Parentheses {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
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
