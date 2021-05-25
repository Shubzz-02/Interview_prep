package com.company.leetcode.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String v = br.readLine();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(isSubsequence(br.readLine(), v));
        }
    }

    public static String isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int i = 0, j = 0;
        while (i < slen && j < tlen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == slen) return "POSITIVE";
        else return "NEGATIVE";
    }
}
