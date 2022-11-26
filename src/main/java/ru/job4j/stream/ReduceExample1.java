package ru.job4j.stream;


import java.util.List;
import java.util.Optional;

public class ReduceExample1 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        Optional<Integer> sum = nums.stream()
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }
}

