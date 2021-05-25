package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prog1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(minCost(arr));
    }

    private static int minCost(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < 1000_00; i++) {
            if (map.containsKey(i) && map.get(i)>=2)
                list.add(i * (map.get(i) - 1));
            else if (list.size() > 0 && (!map.containsKey(i) || map.get(i) == 0)) {
                ans += i - list.get(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
        return ans;
    }
}
