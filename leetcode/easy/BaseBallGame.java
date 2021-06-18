package com.company.leetcode.easy;

import java.util.Stack;

public class BaseBallGame {
    public static void main(String[] args) {
        System.out.println(new SolutionBG().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}


class SolutionBG {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String i : ops) {
            try {
                Integer a = Integer.parseInt(i);
                stack.push(a);
            } catch (NumberFormatException e) {
                if (i.equals("C"))
                    stack.pop();
                else if (i.equals("D"))
                    stack.push(stack.peek() * 2);
                else {
                    int f = stack.pop();
                    int ad = stack.peek() + f;
                    stack.push(f);
                    stack.push(ad);
                }
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}
