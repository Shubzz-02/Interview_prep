package com.company.codechef.starters.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodeChef1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] xy = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            while (nm[0]-- > 0) {
                String sq = br.readLine();
                System.out.print(canPass(nm[1], xy[0], xy[1], sq));
            }
            System.out.println();
        }
    }

    private static int canPass(int m, int x, int y, String sq) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('F', 0);
        map.put('U', 0);
        map.put('P', 0);
        for (int i = 0; i < m; i++) {
            map.put(sq.charAt(i), map.getOrDefault(sq.charAt(i), 0) + 1);
        }
        if (map.get('F') >= x)
            return 1;
        else if ((map.get('F') == (x - 1) || (map.get('F') == 0 && (x == 1 || x == 0))) && map.get('P') >= y)
            return 1;
        else
            return 0;
    }
}
