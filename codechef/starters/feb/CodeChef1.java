package com.company.codechef.starters.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodeChef1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(isNoblePossible(nm[0], nm[1], arr));
        }
    }

    private static String isNoblePossible(int n, int m, int[] arr) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (!set.contains(i)) {
                sum += i;
                set.add(i);
            }
        }
        int fns = (m * (m + 1)) / 2;
        if (sum == fns)
            return "No";
        else
            return "Yes";
    }
}
