package ru.job4j.stream;

import java.util.*;
import java.util.stream.IntStream;

public class MinExample2 {
    public static void main(String[] args) {
        OptionalInt min = IntStream
                .rangeClosed(1, 5)
                .min();
        if (min.isPresent()) {
            System.out.println(min.getAsInt());
        }
    }
}