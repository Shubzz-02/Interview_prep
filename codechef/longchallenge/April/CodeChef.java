package com.company.codechef.longchallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] abc = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(existSameColor(abc[0], abc[1], abc[2]));
    }

    private static String existSameColor(int a, int b, int c) {
        if (a == b || a == c)
            return "Yes";
        else
            return "NO";
    }
}
