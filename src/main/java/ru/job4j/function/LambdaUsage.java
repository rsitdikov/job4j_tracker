package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] cities = {"Tula", "Moscow",
                "Saratov", "Vladivostok", "Ekaterinburg"};
        System.out.println("Before sorting: "
                + Arrays.toString(cities));
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return left.compareTo(right);
        };
        System.out.println("Sort by text...");
        Arrays.sort(cities, cmpText);
        System.out.println("After sorting by text: "
                + Arrays.toString(cities));
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.length() + " : "
                    + right.length());
            return Integer.compare(right.length(), left.length());
        };
        System.out.println("Reverse sort by length...");
        Arrays.sort(cities, cmpDescSize);
        System.out.println("After reverse sorting by length: "
                + Arrays.toString(cities));
    }
}
