package com.company.codechef.longchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodeChef4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] w = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] l = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(minHitOnBack(w, l, n));
        }
    }

    private static int minHitOnBack(int[] w, int[] l, int n) {
        List<Integer> cps = new ArrayList<>();
        for (int i = 0; i < n; i++)
            cps.add(i);
        List<Integer> sorted = Arrays.stream(w).boxed().sorted().collect(Collectors.toList());
        int ct = 0;
        for (int i = 1; i < n; i++) {
            int ind = findIndex(w, sorted.get(i), n);
            int pos = cps.get(findIndex(w, sorted.get(i - 1), n));
            int c = ind;
            while (c <= pos) {
                c += l[ind];
                cps.set(ind, c);
                ct++;
            }
        }
        return ct;
    }

    private static int findIndex(int[] w, int e, int n) {
        int i = 0;
        while (i < n) {
            if (w[i] == e) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }
}
