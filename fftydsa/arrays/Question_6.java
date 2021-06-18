package com.company.fftydsa.arrays;

import jdk.jfr.Description;
import jdk.jfr.Label;

import java.util.*;
import java.util.stream.Collectors;

public class Question_6 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 6};
        System.out.println(new Solution_6().doUnionNaive(a, a.length, b, b.length));
        System.out.println(new Solution_6().doIntersection(a, a.length, b, b.length));
    }
}


@Label("Find the Union and Intersection of the two sorted arrays.")
class Solution_6 {

    @Description("(UNION) Using Set Properties")
    public int doUnion(int[] a, int n, int[] b, int m) {
        Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        set.addAll(Arrays.stream(b).boxed().collect(Collectors.toSet()));
        return set.size();
    }

    @Description("(UNION) Using MAP!!!!!!")
    public int doUnionMap(int[] a, int n, int[] b, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], i);
        }
        for (int i = 0; i < m; i++) {
            map.put(b[i], i);
        }
        return map.size();
    }

    @Description("(UNION) Using Naive approach  (TLE) ")
    public int doUnionNaive(int[] a, int n, int[] b, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!list.contains(a[i]))
                list.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            if (!list.contains(b[i]))
                list.add(b[i]);
        }
        return list.size();
    }

    @Description("(Intersection) Using SEt Properties")
    public int doIntersection(int[] a, int n, int[] b, int m) {
        Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        set.retainAll(Arrays.stream(b).boxed().collect(Collectors.toSet()));
        return set.size();
    }
}
