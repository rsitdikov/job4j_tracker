package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .map(Pupil::getSubjects)
                .flatMap(List::stream)
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects().stream()
                        .mapToInt(s -> s.getScore())
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(Pupil::getSubjects)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)
                ))
                .entrySet()
                .stream()
                .map(m -> new Tuple(m.getKey(), m.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Tuple::compareTo)
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .map(Pupil::getSubjects)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)
                ))
                .entrySet()
                .stream()
                .map(m -> new Tuple(m.getKey(), m.getValue()))
                .max(Tuple::compareTo)
                .orElse(null);
    }
}