package com.company.etc;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1 MB");
        list.add("10 PB");
        list.add("1 TB");
        list.add("1024 KB");
        list.add("4 B");
        list.add("5 TB");
        list.add("10 PB");
        list.add("1 B");
        list.add("100 TB");
        list.add("4 PB");

        list.sort(new Data());


        System.out.println(Arrays.toString(list.toArray()));
    }

}

class Data implements Comparator<String> {

    Map<String, Integer> map;


    private Map<String, Integer> initMap() {
        map = new HashMap<>();
        map.put("B", 0);
        map.put("KB", 1);
        map.put("MB", 2);
        map.put("GB", 3);
        map.put("TB", 4);
        map.put("PB", 5);
        return map;
    }

    @Override
    public int compare(String o1, String o2) {
        map = initMap();
        String[] oa1 = o1.trim().split(" ");
        String[] oa2 = o2.trim().split(" ");
        if (Objects.equals(map.get(oa1[1]), map.get(oa2[1])))
            return Integer.parseInt(oa1[0]) - Integer.parseInt(oa2[0]);
        else
            return map.get(oa1[1]) - map.get(oa2[1]);
    }
}