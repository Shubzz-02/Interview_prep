package com.company.Google;

import java.util.LinkedList;
import java.util.Queue;

public class Prog4 {

    public static void main(String[] args) {


        System.out.println(solution(new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        }));
    }

    public static int solution(int[][] map) {
        int r = map.length, c = map[0].length;
        int[][] a = minPath(0, 0, map);
        int[][] b = minPath(r - 1, c - 1, map);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (a[i][j] != 0 && b[i][j] != 0)
                    ans = Math.min(a[i][j] + b[i][j] - 1, ans);
        return (int) ans;
    }

    private static int[][] minPath(int sr, int sc, int[][] map) {
        int r = map.length, c = map[0].length;
        int[][] board = new int[r][c];
        board[sr][sc] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int[][] dir = new int[][]{
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0}
        };
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] cd = dir[i];
                int nx = xy[0] + cd[0];
                int ny = xy[1] + cd[1];
                if (0 <= nx && 0 <= ny && nx < r && ny < c)
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = board[xy[0]][xy[1]] + 1;
                        if (map[nx][ny] == 1)
                            continue;
                        queue.add(new int[]{nx, ny});
                    }
            }
        }
        return board;
    }
}
