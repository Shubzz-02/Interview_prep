package com.company.codechef.starters.feb;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] roc = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(canWinOrNOt(roc[0], roc[1], roc[2]));
    }

    private static String canWinOrNOt(int r, int o, int c) {
        int rem = 20 - o;
        int bp = rem * 6;
        int maxs = c + (bp * 6);
        if (maxs > r)
            return "Yes";
        else
            return "No";
    }
}
