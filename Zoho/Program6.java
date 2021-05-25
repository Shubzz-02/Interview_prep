package com.company.Zoho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Program6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rc[0], c = rc[1];
        int k = 1;
        int[][] arr = new int[rc[0]][rc[1]];
        int rt = 0, rb = r - 1;
        int cl = 0, cr = c - 1;
        while (k <= r * c) {
            for (int i = cl; i <= cr; i++) {
                arr[rt][i] = k++;
            }
            for (int i = rt + 1; i <= rb; i++) {
                arr[i][cr] = k++;
            }
            for (int i = cr - 1; i >= cl; i--) {
                arr[rb][i] = k++;
            }
            for (int i = rb - 1; i >= rt + 1; i--) {
                arr[i][cl] = k++;
            }
            cl++;
            rt++;
            cr--;
            rb--;
        }
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
