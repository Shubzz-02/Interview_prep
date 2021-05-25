package com.company.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] grid = {
                {'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O'}
        };

        new SolutionSR().solve(grid);

        for (char[] chars : grid) {
            System.out.println(Arrays.toString(chars));
        }
    }


}

class SolutionSR {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        if (col == 0)
            return;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') BFS(board, i, 0, row, col);
            if (board[i][col - 1] == 'O') BFS(board, i, col - 1, row, col);
        }

        for (int i = 1; i <= col - 2; i++) {
            if (board[0][i] == 'O') BFS(board, 0, i, row, col);
            if (board[row - 1][i] == 'O') BFS(board, row - 1, i, row, col);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    private void BFS(char[][] board, int i, int j, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][]{
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0}
        };
        board[i][j] = '*';
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] d : dir) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];
                if ((r >= 0 && r < row) && (c >= 0 && c < col) && board[r][c] == 'O') {
                    board[r][c] = '*';
                    queue.add(new int[]{r, c});
                }
            }
        }
    }

}


