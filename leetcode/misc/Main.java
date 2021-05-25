package com.company.leetcode.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] a = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] b = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(xorAnd(nm[0], nm[1], a, b));
        }
    }

    private static int xorAnd(int N, int M, int[] A, int[] B) {
        int aXor = 0;
        int bXor = 0;
        for(int i:A)
            aXor ^= i;
        for(int i:B)
            bXor ^= i;
        return aXor&bXor;
    }
}
