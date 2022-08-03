package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.List;

public class _729_My_Calendar_I {

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(47, 50));
        System.out.println(calendar.book(33, 41));
        System.out.println(calendar.book(39, 45));
        System.out.println(calendar.book(33, 42));
        System.out.println(calendar.book(25, 32));
        System.out.println(calendar.book(26, 35));
        System.out.println(calendar.book(19, 25));
        System.out.println(calendar.book(3, 8));
        System.out.println(calendar.book(8, 13));
        System.out.println(calendar.book(18, 27));

    }


}
//["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
//        [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]

class MyCalendar {

    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for (int[] cur : list) {
            if (cur[0] < end && start < cur[1]) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}