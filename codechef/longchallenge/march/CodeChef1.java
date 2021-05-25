package com.company.codechef.longchallenge.march;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeChef1 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            long startTime = System.currentTimeMillis();
            System.out.println(countGroups(s));
            long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime) + "ms");
        }
    }

    private static int countGroups(String s) {
        int g = 0;
        int sz = s.length();
        int i = 0;
        while (i < sz) {
            int nc = 0;
            while (i < sz && s.charAt(i) == '1') {
                nc++;
                i++;
            }
            if (nc > 0) {
                i--;
                g++;
            }
            i++;
        }
        return g;
    }
}
