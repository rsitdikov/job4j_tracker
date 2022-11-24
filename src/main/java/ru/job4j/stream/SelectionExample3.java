package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionExample3 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> rsl = strings
                .stream()
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(rsl);
    }
}
