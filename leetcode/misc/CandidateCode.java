package com.company.leetcode.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CandidateCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ans = new CandidateCode().productExceptSelf(arr, n);
        for (int i : ans)
            System.out.print(i + " ");
    }

    public int[] productExceptSelf(int[] a, int n) {
        int prod = 1;
        int flag = 0;
        for (int j : a) {
            if (j == 0)
                flag++;
            else
                prod *= j;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (flag > 1)
                arr[i] = 0;
            else if (flag == 0)
                arr[i] = (prod / a[i]);
            else if (flag == 1 && a[i] != 0)
                arr[i] = 0;
            else
                arr[i] = prod;
        }
        return arr;
    }
}
