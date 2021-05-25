package com.company.codechef.lunchtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getNumber(n, arr));
        }
    }

    private static int getNumber(int n, int[] arr) {
        int nod = 0;
        int nie = 0;
        int nid = 0;
        for (int i : arr) {
            final double max = Math.max(0, Math.ceil(i / 2f) - 1);
            if (i % 2 == 1) {
                nod++;
                int p = (int) max;
                if (Math.pow(i, p) % 2 == 0)
                    nid++;
            } else {
                int p = (int) max;
                if (Math.pow(i, p) % 2 == 1D)
                    nie++;
            }
        }
        if (n % 2 == 1 && nod == n && nid > 0) {
            return 1;
        } else if (nod % 2 == 0) {
            return 0;
        } else if (nie > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
