package com.company.codechef.starters.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] in = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(canSurvive(in[0], in[1], in[2], in[3], in[4]));
        }
    }

    private static String canSurvive(int x, int y, int xr, int yr, int d) {
        double fs = ((double) x / (double) xr);
        double ws = ((double) y / (double) yr);
        double cs = Math.min(fs, ws);
        if (cs >= d)
            return "YES";
        else
            return "NO";
    }


}
