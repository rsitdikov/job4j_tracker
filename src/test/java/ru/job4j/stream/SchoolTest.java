package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    List<Student> students = List.of(
            new Student("Ivanov", 100),
            new Student("Petrov", 22),
            new Student("Sidorov", 43),
            new Student("Sergeev", 54),
            new Student("Makarov", 65),
            new Student("Vasil'ev", 36),
            new Student("Savel'ev", 87)
    );

    @Test
    public void whenScopeLess50ThenClassC() {
        Predicate<Student> predicate = student -> student.getScope() < 50;
        List<Student> expected = List.of(
                new Student("Petrov", 22),
                new Student("Sidorov", 43),
                new Student("Vasil'ev", 36)
        );
        List<Student> result = new School().collect(students, predicate);
        assertThat(result, is(expected));
    }
    @Test
    public void whenScopeGreaterOrEqual50AndLess70ThenClassB() {
        Predicate<Student> predicate = student -> student.getScope() >= 50 && student.getScope() < 70;
        List<Student> expected = List.of(
                new Student("Sergeev", 54),
                new Student("Makarov", 65)
        );
        List<Student> result = new School().collect(students, predicate);
        assertThat(result, is(expected));
    }
    @Test
    public void whenScopeGreaterOrEqual70AndLessOrEqual100ThenClassA() {
        Predicate<Student> predicate = student -> student.getScope() >= 70 && student.getScope() <= 100;
        List<Student> expected = List.of(
                new Student("Ivanov", 100),
                new Student("Savel'ev", 87)
        );
        List<Student> result = new School().collect(students, predicate);
        assertThat(result, is(expected));
    }
    @Test
    public void whenConvertListThenResultMap() {
        Map<String, Student> expected = Map.of(
                "Ivanov", new Student("Ivanov", 100),
                "Petrov", new Student("Petrov", 22),
                "Sidorov", new Student("Sidorov", 43),
                "Sergeev", new Student("Sergeev", 54),
                "Makarov", new Student("Makarov", 65),
                "Vasil'ev", new Student("Vasil'ev", 36),
                "Savel'ev", new Student("Savel'ev", 87)
        );
        Map<String, Student> result = new School().convertListToMap(students);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLevelOf35ThenResultListOfStudentsWithScopesGreaterThan35() {
        List<Student> students = Arrays.asList(
                null,
                new Student("Ivanov", 100),
                null,
                new Student("Petrov", 22),
                null,
                new Student("Sidorov", 43),
                null,
                new Student("Sergeev", 54),
                null,
                new Student("Makarov", 65),
                null,
                new Student("Vasil'ev", 35),
                null,
                new Student("Savel'ev", 87),
                null
        );
        List<Student> expected = List.of(
                new Student("Ivanov", 100),
                new Student("Savel'ev", 87),
                new Student("Makarov", 65),
                new Student("Sergeev", 54),
                new Student("Sidorov", 43)

        );
        assertThat(new School().levelOf(students, 35), is(expected));
    }
}
