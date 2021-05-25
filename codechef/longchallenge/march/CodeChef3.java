package com.company.codechef.longchallenge.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeChef3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        xor();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(getProduct(n));
        }
    }

    private static long getProduct(int n) {
        int a = 2;
        for (int i = 1; i <= 32; i++) {
            if (n < (1 << i)) {
                a = (1 << i);
                break;
            }
        }
        //long max = 0;
        int las = (a / 2) - 1;
        //        for (int i = (a / 2) - 1; i >= 0; i--) {
//            int xor = n ^ i;
//            long mul = (long) xor * i;
//            System.out.println(i + "*" + xor + " = " + mul);
//            if (mul > max)
//                max = mul;
//        }
        return (long) (n ^ las) * las;
    }

//    private static void xor() {
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < 16 / 2; i++) {
//            int xor = (i ^ 13);
//            String a = (i + " * " + xor);
//            if (!map.containsKey(a)) {
//                String[] arr = a.trim().split(" ");
//                String b = arr[2] + " " + arr[1] + " " + arr[0];
//                if (map.containsKey(b)) {
//                    map.put(b, map.get(b) + 1);
//                } else {
//                    map.put(a, 1);
//                }
//            }
//            //map.put(a, map.getOrDefault(a, 0) + 1);
//            // System.out.println(i + "^32 = " + xor);
//            //System.out.println();
//        }
//        map.forEach((k, v) ->
//                System.out.println(k + " = " + v));
//        //System.out.println(map);
//    }
}


/*
private static long getProduct(int n) {
        String nb = Integer.toBinaryString(n);
        int max = 0;
        int len = nb.length();
        int a = 1 << len;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= a/2; j++) {
                if ((i ^ j) == n) {
                    if (max < (i * j))
                        max = (i * j);
                }
            }
        }
        return max;
    }
 */
