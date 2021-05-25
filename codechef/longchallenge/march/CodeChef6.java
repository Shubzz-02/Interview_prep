package com.company.codechef.longchallenge.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeChef6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] in = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        //    System.out.println(whereToPutPaparazi(n, in));
        }
    }

//    private static int whereToPutPaparazi(int n, int[] in) {
//        if (n == 2)
//            return 1;
//        List<Map<Integer, Integer>> v = new ArrayList<>();
//        Map<Integer, Integer> map;
//        {
//            map = new HashMap<>();
//            map.put(0, in[0]);
//            v.add(map);
//        }
//        {
//            map = new HashMap<>();
//            map.put(0, in[1]);
//            v.add(map);
//        }
//
//        int result = 1;
//        for (int i= 2;i<n;i++){
//            int size = v.size();
//            while (size >= 2){
//                double vs1,vs2;
//                vs1 = ((double) ((double) v.get(size-1).))
//            }
//        }
//    }
}
