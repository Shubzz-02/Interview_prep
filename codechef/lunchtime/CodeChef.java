package com.company.codechef.lunchtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nx = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] sr = new int[nx[0]][2];
            for (int i = 0; i < nx[0]; i++) {
                sr[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            System.out.println(bestMovie(nx, sr));
        }
    }

    private static int bestMovie(int[] nx, int[][] sr) {
        int max = 0;
        for (int[] i : sr) {
            if (i[0] <= nx[1] && max < i[1])
                max = i[1];
        }
        return max;
    }
}
