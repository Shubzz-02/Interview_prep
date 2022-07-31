package com.company.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(Arrays.toString(can(2, 2, arr, 3, new long[]{1, 4, 3})));
    }

    static int[] can(int N, long X, int[] arr, int Q, long[] pos) {
        int[] result = new int[Q];

//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < X; i++) {
//            list.addAll(Arrays.stream(arr).boxed()
//                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
//        }
//
//        Collections.sort(list);
        Arrays.sort(arr);
        for (int i = 0; i < Q; i++) {
            int p = (int) ((pos[i]-1));
            if(p %2 == 1){
                p = p-1;
                p= p/2;
            }else{
                p = p/2;
            }
            result[i] = arr[(int) p];
        }
        return result;
    }

}
