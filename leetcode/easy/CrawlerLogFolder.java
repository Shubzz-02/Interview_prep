package com.company.leetcode.easy;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        System.out.println(new SolutionCLF().minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
    }
}


class SolutionCLF {
    public int minOperations(String[] logs) {
        int ct = 0;
        for (String i : logs) {
            if (i.matches("([a-zA-Z0-9]+)/"))
                ct++;
            else if (i.matches("../")) {
                if (ct != 0) ct--;
            }
        }
        return ct;
    }
}
