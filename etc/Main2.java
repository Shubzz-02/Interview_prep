package com.company.etc;

import java.io.File;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Base {

    public static void show() {
        System.out.println("Base::show() called");
    }

}

class Derived extends Base {

    public static void show() //line 1

    {
        System.out.println("Derived::show() called");
    }

    public void check() {
        System.out.println("check called");
    }
}

public class Main2 {

    public static void main(String[] args) {

        Integer val1 = 100;

        Integer val2 = 2;

        Integer val3 = val1 %= 3 + ++val1 + val2--;

        System.out.println(val3 %= 7);

        Stream<String> inputStream = Stream.of("Java", "Programmer", "Mock");
        LocalDate local= LocalDate.of(2020,1,1);
        System.out.println(local);
        local=local.minusMonths(-5);

        local=local.minusDays(9);

        System.out.println(local);

        File obj = new File("/java/system");

        System.out.print(obj.getParent());

        System.out.print(" " + obj.isFile());

    }
}