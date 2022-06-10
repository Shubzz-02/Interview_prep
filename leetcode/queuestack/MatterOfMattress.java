package com.company.leetcode.queuestack;


public class MatterOfMattress {
    public static void main(String[] args) {
        int[] ans = solve(8, new int[][]{
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0}
        });
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] solve(int n, int[][] arr) {
        int[] ans = new int[2];
        int[] level = new int[n];
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                level[i] = 0;
            } else {
                level[i] = level[arr[i][0] - 1] + 1;
            }
            start[i] = arr[i][1];
            end[i] = arr[i][2];
        }
        ans[0] = n;
        ans[1] = n - level[n - 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (level[i] == n - 1) {
                max = Math.max(max, end[i] - start[i]);
            }
        }
        ans[1] = Math.max(ans[1], max);
        return ans;
    }
}
