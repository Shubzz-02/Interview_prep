package com.company.leetcode.queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    public static void main(String[] args) {
        System.out.println(new SolutionNOI().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }
}

class SolutionNOI {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int noi = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][]{
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0}
        };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    noi++;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int[] d : dir) {
                            int r = curr[0] + d[0];
                            int c = curr[1] + d[1];

                            if ((r >= 0 && r < row) && (c >= 0 && c < col) && grid[r][c] == '1') {
                                queue.add(new int[]{r, c});
                                grid[r][c] = '2';
                            }
                        }
                    }
                }
            }
        }
        return noi;
    }
}
