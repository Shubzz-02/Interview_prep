package com.company.etc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test   {
    public static void main(String[] args) {

        Map<Integer, String> myMap = new LinkedHashMap<>();

        myMap.put(0, "Java");

        myMap.put(1, "Programmer");

        myMap.put(3, "Mock");

        myMap.putIfAbsent(3, "Certification");

        System.out.println(myMap.values());


        LocalDate orderDate = LocalDate.of(2020, Month.JANUARY, 12);

        LocalTime orderTime = LocalTime.of(12, 12, 12);

        LocalDate dispacthDate = orderDate.plusMonths(1).plusWeeks(7).plusDays(9);

        LocalTime dispacthTime = orderTime.MIDNIGHT.plusHours(1);

        System.out.println("Your Order has been dispatched on "+dispacthDate+ " at "+dispacthTime);


        String name = "Sherlock Holmes";

        String regex="[(A-Z)][(a-z)]*( (A-Z){1}[a-z]*)*"; //line 1

        System.out.println(name.matches(regex));

    }
}
