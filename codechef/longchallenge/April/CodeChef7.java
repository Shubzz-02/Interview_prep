package com.company.codechef.longchallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeChef7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        while (t-- > 0) {
            String in = br.readLine();
            System.out.println(findMinNo(in));
        }
//        System.out.println(Integer.parseInt("1001011", 2));
//        String a = "1001011";
//        System.out.println(a.contains("1001"));
    }

    private static String findMinNo(String in) {
        long n = Integer.parseInt(in, 2);
        for (long i = 0; i <= n; i++) {
            String b = Long.toBinaryString(i);
            if (!in.contains(b))
                return b;
        }
        return null;
    }
}

