package com.company.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prog1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] y = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(x, y));
    }

//    public static int solution(int[] x, int[] y) {
//        Set<Integer> sx = Arrays.stream(x).boxed().collect(Collectors.toSet());
//        Set<Integer> sy = Arrays.stream(y).boxed().collect(Collectors.toSet());
//        Set<Integer> sc = new HashSet<>(sx);
//        sc.addAll(sy);
//        sx.retainAll(sy);
//        sc.removeAll(sx);
//        return sc.iterator().next();
//        //Set<Integer> sy = Arrays.stream(x).boxed().collect(Collectors.toSet());
//    }

    public static int solution(int[] x, int[] y) {
//        Set<Integer> sx = Arrays.stream(x).boxed().collect(Collectors.toSet());
//        Set<Integer> sy = Arrays.stream(y).boxed().collect(Collectors.toSet());
        Set<Integer> sx = new HashSet<>();
        Set<Integer> sy = new HashSet<>();
        for (int j : x) {
            sx.add(j);
        }
        for (int j : y) {
            sy.add(j);
        }
        Set<Integer> sc = new HashSet<>(sx);
        sc.addAll(sy);
        Set<Integer> si = new HashSet<>(sx);
        si.retainAll(sy);
        Set<Integer> sd = new HashSet<>(sc);
        sd.removeAll(si);
        return sd.iterator().next();
    }
}
/*
13 5 6 2 5
5 2 5 13

14 27 1 4 2 50 3 1
2 4 -4 3 1 1 14 27 50

13 5 6 2 5
5 2 5 13

14 27 1 4 2 50 3 1
2 4 -4 3 1 1 14 27 50
 */
