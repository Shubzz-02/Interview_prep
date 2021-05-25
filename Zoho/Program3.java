package com.company.Zoho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Program3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[rc[0]][rc[1]];
        for (int i = 0; i < rc[0]; i++) {
            arr[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(findNumber(rc[0], rc[1], arr));
    }

    private static int findNumber(int r, int c, int[][] arr) {
        int minC, maxC;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                minC = arr[i][j];
                maxC = arr[i][j];
                for (int k = 0; k < c; k++) {
                    if (arr[i][k] < minC)
                        minC = arr[i][k];
                }
                for (int k = 0; k < r; k++) {
                    if (arr[k][j] > maxC)
                        maxC = arr[k][j];
                }
                if (minC == maxC)
                    return minC;
            }
        }
        return -1;
    }
}

/*
3 3
3 11 7
5 9 14
2 4 5


4 2
4 11
9 8
3 27
7 7


3 4
4 7 0 13
8 5 3 1
42 23 4 9
 */
