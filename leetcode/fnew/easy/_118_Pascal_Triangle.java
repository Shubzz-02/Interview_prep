package com.company.leetcode.fnew.easy;

import java.util.ArrayList;
import java.util.List;

public class _118_Pascal_Triangle {

    public static void main(String[] args) {
        new _118_Pascal_Triangle().generate(6).forEach(System.out::println);
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }

            list.add(row);
        }
        return list;
    }
}
