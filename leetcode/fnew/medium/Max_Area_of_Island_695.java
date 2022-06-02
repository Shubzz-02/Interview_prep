package com.company.leetcode.fnew.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Max_Area_of_Island_695 {

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

        System.out.println(new Max_Area_of_Island_695().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int[][] dir = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int ca = 1;
                    queue.add(new int[]{i, j});
                    grid[i][j] = 0;
                    while (!queue.isEmpty()) {
                        int[] ci = queue.poll();

                        for (int k = 0; k < dir.length; k++) {
                            int x = ci[0] + dir[k][0];
                            int y = ci[1] + dir[k][1];

                            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                                    && grid[x][y] == 1) {
                                ca++;
                                queue.add(new int[]{x, y});
                                grid[x][y] = 0;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, ca);
                }
            }
        }
        return maxArea;
    }

}
