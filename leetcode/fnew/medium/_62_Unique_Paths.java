package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _62_Unique_Paths {

    public static void main(String[] args) {
        System.out.println(new _62_Unique_Paths().uniquePaths(3, 2));
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, 1);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


//    public int uniquePaths(int m, int n) {
//
//            int[][] dir = new int[][]{
//                    {0, 1},
//                    {1, 0}
//            };
//
//            Queue<int[]> queue = new LinkedList<>();
//            queue.offer(new int[]{0, 0});
//
//            int total = 0;
//            while (!queue.isEmpty()) {
//
//                int[] curr = queue.poll();
//                int cx = curr[0];
//                int cy = curr[1];
//
//                if (cx == m - 1 && cy == n - 1) {
//                    total++;
//                }
//
//                for (int i = 0; i < 2; i++) {
//                    int x = cx + dir[i][0];
//                    int y = cy + dir[i][1];
//
//                    if (x >= 0 && x < m && y >= 0 && y < n) {
//                        queue.add(new int[]{x, y});
//                    }
//                }
//            }
//            return total;
//    }

}
