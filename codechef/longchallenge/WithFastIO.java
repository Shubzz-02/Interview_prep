package com.company.codechef.longchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WithFastIO {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] in = br.readLine().trim().split(" ");
            System.out.println(Arrays.toString(in));
            System.out.println(possibleTeamName(in, n));
        }
    }

    private static int possibleTeamName(String[] in, int n) {
        Map<String, Set<Character>> map = new HashMap<>();
        Set<Character> ch = new HashSet<>();
        ch.add(in[0].charAt(0));
        map.put(in[0].substring(1), ch);
        for (int i = 1; i < n; i++) {
            String body = in[i].substring(1);
            //map.put(body, map.getOrDefault(body,))
            Set<Character> chh;
            if (map.containsKey(body)) {
                chh = map.get(body);
            } else {
                chh = new HashSet<>();
            }
            chh.add(in[i].charAt(0));
            map.put(body, chh);
        }

//        if (map.size() == n)
//            return 0;
        String[] keys = map.keySet().toArray(new String[0]);
        int ct = 0;
        int len = keys.length;
        for (int i = 0; i < len - 1; i++) {
            int j = len - 1;
            while (i < j) {
                Set<Character> f = map.get(keys[i]);
                Set<Character> s = map.get(keys[j]);
                //f.addAll(s);
                Set<Character> d = symmetricDifference(f, s);
                //System.out.println(d);
                ct += d.size();
                j--;
            }
        }
        //map.forEach((key, value) -> System.out.println(key + " " + value));
        return ct;
    }

    private static <T> Set<T> symmetricDifference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        for (T element : b) {
            // .add() returns false if element already exists
            if (!result.add(element)) {
                result.remove(element);
            }
        }
        return result;
    }


}
