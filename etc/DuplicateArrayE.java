package com.company.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DuplicateArrayE {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new DuplicateArrayE().DuplicateArray(6, new int[]{4,5, 7, 8,6 , 9})));
    }


    public int[] DuplicateArray(int input1, int[] input2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < input1; i++) {
            map.put(input2[i], map.getOrDefault(input2[i], 0) + 1);
        }

        List<Integer> list  = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() != 1){
                list.add(entry.getKey());
            }
        }

        if(list.isEmpty()){
            list.add(-1);
        }

        return list.stream().mapToInt(i->i).toArray();
    }

}
