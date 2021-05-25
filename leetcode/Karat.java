package com.company.leetcode;

import java.util.*;

/*
{'c', 'c', 'c', 't', 'i', 'b'},
                {'c', 'c', 'a', 't', 'n', 'i'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'c', 's', 'i', 'p', 't'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'o', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'c', 'k', 'i'}
 */

public class Karat {
    public static void main(String[] args) {
        char[][] grid = {
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'}
        };
        String word1 = "aaaaaaaaaaaaa";
        String word2 = "cccc";
        List<int[]> ans = find_word_location(grid, word1);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(Arrays.toString(ans.get(i)) + " ");
        }
    }

    private static List<int[]> find_word_location(char[][] grid, String word) {
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
                List<Object> list = new ArrayList<>();
                if (grid[i][j] == word.charAt(0)) {
                    int[] cp = new int[]{i, j};
                    list.add(cp);
                    list.add(1);
                    int[] finalCp = cp;
                    list.add(new ArrayList<int[]>() {{
                        add(finalCp);
                    }});
                    list.add(new int[]{-1, -1});
                    queue.add(list);
                    while (!queue.isEmpty()) {
                        List<Object> cList = queue.poll();
                        int[] cur = (int[]) cList.get(0);
                        for (int l = 0; l < 4; l++) {
                            int cInd = (int) cList.get(1);
                            int r = cur[0] + dir[l][0];
                            int c = cur[1] + dir[l][1];
                            List<Object> tList = new ArrayList<>();
                            cp = new int[]{r, c};
                            if (cInd < len && (r >= 0 && r < row) && (c >= 0 && c < col) && grid[r][c] == word.charAt(cInd) && !Arrays.equals(cp, (int[]) cList.get(3))) {
                                tList.add(cp);
                                tList.add(++cInd);
                                List<int[]> cPos = new ArrayList<>((List<int[]>) cList.get(2));
                                cPos.add(cp);
                                tList.add(cPos);
                                tList.add(cur);
                                queue.add(tList);
                                if (cInd == len)
                                    return (List<int[]>) tList.get(2);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
/*
queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        list.add(curr);
                        for (int[] d : dir) {
                            int r = curr[0] + d[0];
                            int c = curr[1] + d[1];
                            if (ind < len && (r >= 0 && r < row) && (c >= 0 && c < col) && grid[r][c] == word.charAt(ind)) {
                                queue.add(new int[]{r, c});
                                ind++;
                            } else if (ind == len)
                                return list;
                        }
                    }
 */
