package com.company.leetcode.medium;

import java.util.*;

public class WordSearch {
    public static void main(String[] args) {
        char[][] grid = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        String word = "AAB";
        System.out.println(new SolutionWS().exist(grid, word));
    }
}


class SolutionWS {
    public boolean exist(char[][] grid, String word) {
        int len = word.length();
        int row = grid.length;
        int col = grid[0].length;
        Queue<List<Object>> queue = new LinkedList<>();
        int[][] dir = new int[][]{
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0}
        };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (len == 1 && grid[i][j] == word.charAt(0))
                    return true;
                List<Object> list = new ArrayList<>();
                if (grid[i][j] == word.charAt(0)) {
                    int[] cp = new int[]{i, j};
                    list.add(cp);
                    list.add(1);
                    list.add(new int[]{-1, -1});
                    queue.add(list);
                    while (!queue.isEmpty()) {
                        List<Object> cList = queue.poll();
                        int[] cur = (int[]) cList.get(0);
                        for (int[] d : dir) {
                            int cInd = (int) cList.get(1);
                            int r = cur[0] + d[0];
                            int c = cur[1] + d[1];
                            cp = new int[]{r, c};
                            List<Object> tList = new ArrayList<>();
                            if (cInd < len && (r >= 0 && r < row) && (c >= 0 && c < col) && grid[r][c] == word.charAt(cInd)&& !Arrays.equals(cp, (int[]) cList.get(2))) {
                                tList.add(cp);
                                tList.add(++cInd);
                                queue.add(tList);
                                tList.add(cur);
                                if (cInd == len)
                                    return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
