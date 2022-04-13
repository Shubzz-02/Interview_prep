package com.company.dsaprac;


import com.company.annotation.Question;
import com.company.annotation.Solution;

import java.util.HashSet;
import java.util.Set;

@Question(question = "Set Matrix Zero", link = "https://leetcode.com/problems/set-matrix-zeroes/")
public class SetMatrixZero {


    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes2(arr);
        System.out.println("The Final Matrix is ");
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    @Solution(no = 1, approach = "Brute Force", timeComp = "O((N*M)*(N+M)", spaceComp = "O(1)")
    private static void setZeroes(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    for (int a = 0; a < arr.length; a++) {
                        if (arr[a][j] != 0)
                            arr[a][j] = -1;
                    }
                    for (int a = 0; a < arr[i].length; a++) {
                        if (arr[i][a] != 0)
                            arr[i][a] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == -1)
                    arr[i][j] = 0;
            }
        }
    }

    @Solution(no = 2, timeComp = "O(N*M)", spaceComp = "O(N+M)")
    private static void setZeroes2(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (row.contains(i) || col.contains(j))
                    arr[i][j] = 0;
            }
        }
    }

    @Solution(no = 3, timeComp = "O(N*M)", spaceComp = "O(1)")
    private static void setZeroes3(int[][] arr) {
        boolean col = false;
        int r = arr.length;
        int c = arr[0].length;

        for (int i = 0; i < r; i++) {
            if (arr[i][0] == 0)
                col = true;


            for (int j = 1; j < c; j++) {
                if (arr[i][j] == 0) {
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if (arr[0][0] == 0) {
            for (int j = 0; j < c; j++) {
                arr[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < r; i++) {
                arr[i][0] = 0;
            }
        }
    }
}
