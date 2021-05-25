package com.company.Zoho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tr = (n * 2) - 1;
        List<int[]> list = new ArrayList<>();
        int[][] arr = new int[tr][tr];
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j <= tr / 2; j++) {
                arr[i][j] = n - Math.min(i, j);
                if (j != tr / 2)
                    l.add(arr[i][j]);
            }
            //Collections.sort(l);
            int ind = l.size() - 1;
            for (int j = (tr / 2) + 1; j < tr; j++) {
                arr[i][j] = l.get(ind--);
            }
            if (i != n - 1)
                list.add(arr[i]);

        }
        int ct = list.size() - 1;
        for (int i = n; i < tr; i++) {
            arr[i] = list.get(ct--);
        }
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
