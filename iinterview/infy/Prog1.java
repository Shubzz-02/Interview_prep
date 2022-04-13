package com.company.iinterview.infy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prog1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int inf = Integer.parseInt(br.readLine());
        System.out.println(minNum(0, 0, inf, arr));
    }

    static int minNum(int i, int a, int f, int[] arr) {
        int len = arr.length;
        if (i == len)
            return a;
        while (i < len && arr[i] < f) {
            f += arr[i];
            i++;
        }
        if (i == len)
            return a;
        int cf = f + f - 1;
        int m1 = minNum(i, a + 1, cf, arr);
        int m2 = minNum(i + 1, a + 1, f, arr);
        return Math.min(m1, m2);
    }
}
