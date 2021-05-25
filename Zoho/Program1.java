package com.company.Zoho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Program1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int len = arr.length;
        int wi = len - 1;
        int ri = len - 1;
        while (ri >= 0) {
            if (arr[ri] != 0) {
                arr[wi] = arr[ri];
                wi--;
            }
            ri--;
        }
        while (wi >= 0) {
            arr[wi] = 0;
            wi--;
        }
        System.out.println(Arrays.toString(arr));
    }

}
/*
wi = 7
0 4 3 0 8 0 0
9 4 0 11 1 5
23 0 49 0
 */
