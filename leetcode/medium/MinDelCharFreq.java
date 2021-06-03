package com.company.leetcode.medium;

import java.util.*;

public class MinDelCharFreq {

    public static void main(String[] args) {
        System.out.println(new SolutionMDCF().minDeletions("ceabaacb"));
    }
}


class SolutionMDCF {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Set<Character>> map2 = new TreeMap<>(Collections.reverseOrder());

        for (Character c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        Queue<AbstractMap.SimpleEntry<Character, Integer>> queue = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int ct = entry.getValue();
            if (!map2.containsKey(ct))
                map2.put(ct, new HashSet<>());
            map2.get(ct).add(entry.getKey());

            if (map2.get(ct).size() > 1)
                queue.offer(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
        }

//        for (Map.Entry<Integer, Set<Character>> entry : map2.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//
//        }

        //mobile switch off


        int ct = 0;
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Character, Integer> curr = queue.poll();
            Character ch = curr.getKey();
            Integer cf = curr.getValue(), nf = cf - 1;
            map2.get(cf).remove(ch);
            ct++;
            if (nf == 0) continue;
            if (!map2.containsKey(nf))
                map2.put(nf, new HashSet<>());
            map2.get(nf).add(ch);

            if (map2.get(nf).size() > 1)
                queue.offer(new AbstractMap.SimpleEntry<>(ch, nf));
        }

        return ct;
    }
}
