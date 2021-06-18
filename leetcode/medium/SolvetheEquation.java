package com.company.leetcode.medium;

public class SolvetheEquation {
}

class SolutionSTE {
    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String s : eq[0].split("(?=\\+)|(?=-)")) {
            if (s.indexOf('x') >= 0) {
                lhs += Integer.parseInt(coff(s));
            } else
                rhs -= Integer.parseInt(s);
        }
        for (String s : eq[1].split("(?=\\+)|(?=-)")) {
            if (s.indexOf('x') >= 0) {
                lhs -= Integer.parseInt(coff(s));
            } else
                rhs += Integer.parseInt(s);
        }

        if (lhs == 0) {
            if (rhs == 0)
                return "Infinite solutions";
            else
                return "No solution";
        } else {
            return "x=" + rhs / lhs;
        }
    }

    private String coff(String s) {
        int len = s.length();
        if (len > 1 && s.charAt(len - 2) >= '0' && s.charAt(len - 2) <= '9')
            return s.replace("x", "");
        return s.replaceAll("x", "1");
    }
}
