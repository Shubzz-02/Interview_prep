package com.company.codechef.lunchtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(isItPossible(arr[0], arr[1], arr[2], arr[3]));
        }
    }

    private static String isItPossible(int u, int v, int a, int s) {
//        if (u == 1 && v == 1)
//            return "Yes";
//        else {
        double p = Math.pow(u, 2);
//            System.out.println(p);
//            System.out.println(Math.abs(p - (double) (2 * a * s)));
        double v2 = Math.pow(v, 2);
        double fv = p + (double) (2 * -a * s);
        if (fv > v2)
            return "No";
        else
            return "Yes";
        //  }
    }
}
