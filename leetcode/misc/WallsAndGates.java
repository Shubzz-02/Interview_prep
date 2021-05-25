package com.company.leetcode.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {
        char[][] grid = {
                {'_', 'W', 'G', '_'},
                {'_', '_', '_', 'W'},
                {'_', 'W', '_', 'W'},
                {'G', 'W', '_', '_'}
        };
        solve(grid);
        for (char[] i : grid)
            System.out.println(Arrays.toString(i));
    }

    static void solve(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 'G')
                    q.add(new int[]{i, j});
            }
        }
        int level = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        while (!q.isEmpty()) {

            level++;

            int n = q.size();

            for (int i = 0; i < n; i++) {

                int[] point = q.poll();

                for (int j = 0; j < dirs.length - 1; j++) {

                    int x = point[0] + dirs[j];
                    int y = point[1] + dirs[j + 1];

                    if (x >= 0 && y >= 0 && x < row && y < col) {

                        if (grid[x][y] == '_') {

                            grid[x][y] = (char) (48 + level);
                            q.add(new int[]{x, y});
                        }

                    }

                }

            }
        }
    }
}
