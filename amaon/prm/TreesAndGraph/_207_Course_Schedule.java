package com.company.amaon.prm.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _207_Course_Schedule {

    public static void main(String[] args) {

        int numCourse = 7;
        int[][] pq = {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}};

        System.out.println(new _207_Course_Schedule().canFinish(numCourse, pq));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] canComplete = new boolean[numCourses];
        Arrays.fill(canComplete, true);
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] i : prerequisites) {
            List<Integer> list = map.get(i[0]);
            list.add(i[1]);
            map.put(i[0], list);
            canComplete[i[0]] = false;
        }

//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!canComplete[i]) {
                queue.add(i);
                Set<Integer> visited = new HashSet<>();
                while (!queue.isEmpty()) {
                    int c = queue.remove();
                    List<Integer> list = map.get(c);
                    List<Integer> toRemove = new ArrayList<>();
                    for (Integer integer : list) {
                        if (visited.contains(integer) && !canComplete[integer]) {
                            return false;
                        }
                        if (!canComplete[integer]) {
                            if (!queue.contains(integer)) {
                                queue.add(integer);
                            }
                        } else {
                            canComplete[integer] = true;
                            toRemove.add(integer);
                        }
                    }
                    visited.add(c);
                    list.removeAll(toRemove);
                    if (list.size() == 0) {
                        canComplete[c] = true;
                    }
                }
            }
        }

//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        return true;
    }

}
