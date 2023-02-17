package com.company.leetcode.fnew.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _554_Brick_Wall {

    public static void main(String[] args) {
        List<List<Integer>> list = List.of(List.of(1, 2, 2, 1), List.of(3, 1, 2), List.of(1, 3, 2),
                List.of(2, 4), List.of(3, 1, 2), List.of(1, 3, 1, 1));

        System.out.println(new _554_Brick_Wall().leastBricks(list));
    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxGaps = 0;

        for(List<Integer> row : wall) {
            int pos = 0;
            for(int i=0; i<row.size()-1; i++) {
                pos += row.get(i);
                map.put(pos, map.getOrDefault(pos, 0)+1);
                maxGaps = Math.max(maxGaps, map.get(pos));
            }
        }

        return wall.size() - maxGaps;
    }

}
