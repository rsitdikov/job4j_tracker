package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Calc {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        final List<Double> list = new ArrayList<>();
        for (int index = start; index < end; index++) {
            list.add(func.apply((double) index));
        }
        return list;
    }
} 