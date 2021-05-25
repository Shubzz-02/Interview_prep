package com.company.codechef.longchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodeChef2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scanner = new Scanner(System.in);
        //long t = scanner.nextInt();
        long t = Long.parseLong(br.readLine());
        while (t-- > 0) {
            //long n = scanner.nextLong();
            long n = Long.parseLong(br.readLine());
            //scanner.nextLine();
            //String[] in = scanner.nextLine().trim().split(" ");
            String[] in = br.readLine().trim().split(" ");
            long[] array = Arrays.stream(in).mapToLong(Long::parseLong).toArray();
            System.out.println(maximiseFunction(array, n));
        }
    }

    private static long maximiseFunction(long[] array, long n) {
        long x, y, z;
        //Arrays.sort(array);
//        System.out.println("---------- Array -------");
//        for (Long l : array)
//            System.out.print(l + " ");
        Map<Long, Long> map = new HashMap<>();
        for (long i : array) {
            map.put(i, map.getOrDefault(i, 0L) + 1L);
        }
        int size = map.size();
        if (size == 1) return 0;
        Long[] keys = map.keySet().toArray(new Long[0]);
        Arrays.sort(keys);
        if (size == 2) {
            if (map.get(keys[size - 1]) > 1) {
                z = keys[size - 1];
                y = keys[size - 1];
                x = keys[size - 2];
            } else {
                z = keys[size - 1];
                y = keys[size - 2];
                x = keys[size - 2];
            }
        } else {
            z = keys[size - 1];
            y = keys[size / 2];
            x = keys[0];
        }
//        System.out.println("--------------------- KEYS ------------------");
//        for (Long l : keys)
//            System.out.print(l + " ");
//        System.out.println();
//        System.out.println(x + " " + y + " " + z);
        return ((Math.abs(x - y) + Math.abs(y - z) + Math.abs(z - x)));
    }

    private static long optimizedIGuess(long[] array) {
        Arrays.sort(array);
        int n = removeDuplicates(array, array.length);
        if (n == 1) return 0;
        if (n == 2) return 1;
        return 100;
    }

    static int removeDuplicates(long[] arr, int n) {
        if (n == 0 || n == 1)
            return n;
        int j = 0;
        for (int i = 0; i < n - 1; i++)
            if (arr[i] != arr[i + 1])
                arr[j++] = arr[i];
        arr[j++] = arr[n - 1];
        return j;
    }
}
