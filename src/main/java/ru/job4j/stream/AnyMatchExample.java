package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class AnyMatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean rsl = strings
                .stream()
                .anyMatch(e -> e.endsWith("ь"));
        System.out.println(rsl);
    }
}