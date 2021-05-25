package com.company.leetcode.queuestack;

public class NumberOfIslandsDFS {
    public static void main(String[] args) {
        System.out.println(new SolutionNOIDFS().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }
}

class SolutionNOIDFS {
    public int numIslands(char[][] grid) {
        int noi = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    visitAllIsland(grid, i, j);
                    noi++;
                }
            }
        }
        return noi;
    }

    private void visitAllIsland(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && i < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '2';
            visitAllIsland(grid, i - 1, j);
            visitAllIsland(grid, i + 1, j);
            visitAllIsland(grid, i, j + 1);
            visitAllIsland(grid, i, j - 1);
        }
    }
}
