package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    Map<String, Student> convertListToMap(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(
                student -> student.getName(), student -> student));
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted().takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
    }
}
