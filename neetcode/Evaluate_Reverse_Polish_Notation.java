package com.company.neetcode;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {


    public static void main(String[] args) {

        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(new Evaluate_Reverse_Polish_Notation().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {


        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {

                int f = stack.pop();
                int s = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(f + s);
                        break;
                    case "-":
                        stack.push(s - f);
                        break;
                    case "*":
                        stack.push(s * f);
                        break;
                    case "/":
                        stack.push(s / f);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

}
