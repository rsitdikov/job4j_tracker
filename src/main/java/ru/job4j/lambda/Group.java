package ru.job4j.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getUnits()
                                .stream()
                                .map(unit -> new Holder(unit, student.getName()))
                )
                .collect(
                        Collectors.groupingBy(holder -> holder.key,
                                Collector.of(
                                        HashSet::new,
                                        (set, holder) -> set.add(holder.value),
                                                (left, right) -> {
                                            left.addAll(right);
                                            return left;
                                        }
                                )
                        )
                );
    }
}