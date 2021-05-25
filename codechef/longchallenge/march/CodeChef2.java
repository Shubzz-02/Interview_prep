package com.company.codechef.longchallenge.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nhx = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] n = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        long startTime = System.currentTimeMillis();
        System.out.println(isItPossible(nhx, n));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }

    private static String isItPossible(int[] nhx, int[] n) {
        int time_needed = Math.abs(nhx[1] - nhx[2]);
        if (time_needed == 0)
            return "YES";
        Arrays.sort(n);
        int h = Arrays.binarySearch(n, time_needed);
        if (h < 0)
            return "NO";
        else
            return "YES";
    }
}
