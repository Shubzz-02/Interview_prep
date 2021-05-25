package com.company.codechef.starters.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeChef4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            char[][] bord = new char[nm[0]][nm[1]];
            for (int i = 0; i < nm[0]; i++) {
                bord[i] = br.readLine().trim().toCharArray();
            }
            System.out.println(chefTotalScore(nm[0], nm[1], bord));
        }
    }

    private static int chefTotalScore(int n, int m, char[][] bord) {
        boolean[][] seen = new boolean[n][m];
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bord[i][j] == '1' && !seen[i][j]) {
                    int area = 0;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    seen[i][j] = true;
                    while (!stack.isEmpty()) {
                        int[] curr = stack.pop();
                        int r = curr[0], c = curr[1];
                        area++;
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (0 <= nr && nr < n && 0 <= nc && nc < m && bord[nr][nc] == '1' && !seen[nr][nc]) {
                                stack.push(new int[]{nr, nc});
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    list.add(area);
                }
            }
        }
        int score = 0;
        list.sort(Collections.reverseOrder());
        int sz = list.size();
        if (sz <= 1)
            return 0;
        else {
            for (int i = 1; i < sz; i += 2) {
                score += list.get(i);
            }
        }
        return score;
    }
}
