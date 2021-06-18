package com.company.leetcode.june;

import java.util.Stack;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(new SolutionMAI().maxAreaOfIsland(grid));
    }
}

class SolutionMAI {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int max_area = 0;
        int row = grid.length;
        int col = grid[0].length;
        Stack<int[]> stack = new Stack<>();
        int[][] dir = new int[][]{
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0}
        };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = 0;
                    stack.add(new int[]{i, j});
                    grid[i][j] = -1;
                    while (!stack.isEmpty()) {
                        int[] curr = stack.pop();
                        area++;
                        for (int[] d : dir) {
                            int r = curr[0] + d[0];
                            int c = curr[1] + d[1];
                            if ((r >= 0 && r < row) && (c >= 0 && c < col) && grid[r][c] == 1) {
                                stack.add(new int[]{r, c});
                                grid[r][c] = -1;
                            }
                        }
                    }
                    max_area = Math.max(area, max_area);
                }
            }
        }
        return max_area;
    }
}
