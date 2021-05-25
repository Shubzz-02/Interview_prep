package com.company.etc;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBracket {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isValid(input));
        }

    }

    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        stack.push(input.charAt(0));
        int len = input.length();
        for (int i = 1; i < len; i++) {
            char ch = input.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                switch (ch) {
                    case '}':
                        if (stack.peek() == '{')
                            stack.pop();
                        else
                            return false;
                        break;
                    case ']':
                        if (stack.peek() == '[')
                            stack.pop();
                        else
                            return false;
                        break;
                    case ')':
                        if (stack.peek() == '(')
                            stack.pop();
                        else
                            return false;
                        break;
                }
            }else
                return false;
        }

        return stack.isEmpty();
    }
}
