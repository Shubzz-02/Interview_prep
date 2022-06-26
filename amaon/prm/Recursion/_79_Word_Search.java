package com.company.amaon.prm.Recursion;

public class _79_Word_Search {

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'A', 'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A', 'A', 'A'}
        };

        System.out.println(new _79_Word_Search().exist(board, "AAAAAAAAAAAAAAB"));
    }


    int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                if (dfs(board, i, j, 0, word, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int si, String word, int row, int col) {
        if (si == word.length()) {
            return true;
        }
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return false;
        }
        if (word.charAt(si) != board[x][y]) {
            return false;
        }
        char ch = board[x][y];
        board[x][y] = '!';
        for (int i = 0; i < 4; i++) {
            if (dfs(board, x + dir[i][0], y + dir[i][1], si + 1, word, row, col)) {
                board[x][y] = ch;
                return true;
            }
        }
        board[x][y] = ch;
        return false;
    }

//    public boolean exist(char[][] board, String word) {
//        int[][] dir = {
//                {0, 1},
//                {0, -1},
//                {-1, 0},
//                {1, 0}
//        };
//
//        int row = board.length;
//        int col = board[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (board[i][j] == word.charAt(0)) {
//                    boolean[][] vis = new boolean[row][col];
//                    Queue<Pair<int[], boolean[][]>> queue = new LinkedList<>();
//                    vis[i][j] = true;
//                    queue.add(new Pair<>(new int[]{i, j, 0}, vis));
//                    while (!queue.isEmpty()) {
//
//                        Pair<int[], boolean[][]> currPair = queue.remove();
//                        if (currPair.getKey()[2] == word.length() - 1) {
//                            return true;
//                        }
//                        for (int k = 0; k < 4; k++) {
//                            int x = currPair.getKey()[0] + dir[k][0];
//                            int y = currPair.getKey()[1] + dir[k][1];
//
//                            boolean[][] cv = Arrays.stream(currPair.getValue())
//                                    .map(a -> Arrays.copyOf(a, a.length)).toArray(boolean[][]::new);
//                            if (x >= 0 && x < row && y >= 0 && y < col
//                                    && word.charAt(currPair.getKey()[2] + 1) == board[x][y]
//                                    && !cv[x][y]) {
//                                cv[x][y] = true;
//                                queue.add(
//                                        new Pair<>(new int[]{x, y, currPair.getKey()[2] + 1}, cv));
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

}
