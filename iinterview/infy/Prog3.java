package com.company.iinterview.infy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Prog3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ind = Integer.parseInt(br.readLine());
        List<List<Integer>> ans = count(ind);
        for(List<Integer> list : ans)
            System.out.println(list);
    }

    public static List<List<Integer>> count(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = 1;
        int right = (n + 1) / 2;
        while (left < right) {
            int s = 0;
            for (int i = left; i <= right; i++) {
                s = s + i;
                if (s == n) {
                    List<Integer> list = new ArrayList<>();
                    for (int j = left; j <= i; j++)
                        list.add(j);
                    ans.add(list);
                    break;
                }
                if (s > n)
                    break;
            }
            left++;
        }
        return ans;
    }
}
