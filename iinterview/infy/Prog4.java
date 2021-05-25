package com.company.iinterview.infy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prog4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        System.out.println(eval(in));
    }

    public static int eval(String in) {
        Stack<Integer> stack = new Stack<>();
        int len = in.length();
        for (int i = 0; i < len; i++) {
            char ch = in.charAt(i);
            if (ch >= '0' && ch <= '9') {
                stack.push(Character.getNumericValue(ch));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();
                int an = solve(ch, n1, n2);
                stack.push(an);
            }
        }
        return stack.pop();
    }

    private static int solve(char charAt, int n1, int n2) {
        return switch (charAt) {
            case '-' -> n1 - n2;
            case '+' -> n1 + n2;
            case '*' -> n1 * n2;
            case '/' -> n1 / n2;
            default -> 0;
        };
    }
}
