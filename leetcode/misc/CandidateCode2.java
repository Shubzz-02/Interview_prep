package com.company.leetcode.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CandidateCode2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = br.readLine().trim().split(" ");
//        int len = s.length;
//        for (int i = len - 1; i >= 0; i--) {
//            System.out.print(s[i] + " ");
//        }
        String[] sa = {"1", "3", "5", "6", "8", "9", "10", "11", "15", "17", "20", "23", "24", "25", "26", "30"};
        int[] a = Arrays.stream(sa).mapToInt(Integer::parseInt).filter(i -> i % 3 == 0).toArray();
        System.out.println(Arrays.toString(a));

        int[] b = Arrays.stream(sa).mapToInt(Integer::parseInt).toArray();
        var s = Arrays.stream(b);
        System.out.println(s);
    }
}
