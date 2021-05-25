package com.company.codechef.longchallenge.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
//            String[] in = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
//            int[] arr = new int[n];
//            long sum = 0;
//            for (int i = 0; i < n; i++) {
//                arr[i] = Integer.parseInt(in[i]);
//                sum += arr[i];
//            }
            System.out.println(whoWins(arr, n));
        }
    }

    private static String whoWins(int[] arr, int n) {
        Arrays.sort(arr);
        long sum = Arrays.stream(arr).sum();
        long sumN = (long) n * (n + 1) / 2;
        long temp = sumN - sum;
        long f = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1) - arr[i] < 0) {
                f++;
                break;
            }
        }
        if (f == 1 || temp % 2 == 0) {
            return "Second";
        } else
            return "First";
    }
}
