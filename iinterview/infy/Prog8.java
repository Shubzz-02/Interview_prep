package com.company.iinterview.infy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Prog8 {

    public static void main(String[] args) throws IOException {
        int n = 5;
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(
                List.of(2, 4)
        ));
        list.add(new ArrayList<>(
                List.of(1)
        ));
        list.add(new ArrayList<>(
                List.of(1, 5)
        ));
        list.add(new ArrayList<>(
                List.of(2, 3)
        ));
        list.add(new ArrayList<>(
                List.of(5)
        ));

        int[] se = new int[]{2, 3};

        System.out.println(beautifulSub(n, list, se));
    }

    private static int beautifulSub(int n, List<List<Integer>> arr, int[] se) {
        return getMinStep(arr, se[0], se[1], 0);
    }

    private static int getMinStep(List<List<Integer>> arr, int s, int e, int ts) {
        List<Integer> ci = arr.get(s - 1);
        for (int i = 0; i < ci.size(); i++) {
            if (e == ci.get(i))
                return ts;
            getMinStep(arr,ci.get(i),e,ts++);
        }
        return 0;
    }
}
