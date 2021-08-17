package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class GroupTest {

    @Test
    public void whenGroupingIsDone() {
        var input = List.of(
               new Student("Ivanov", Set.of("judo", "chess", "atletics")),
                new Student("Petrov", Set.of("chess", "hockey")),
                new Student("Sidorov", Set.of("hockey", "judo"))
        );

        var result = Group.sections(input);

        assertThat(result.keySet(), is(Set.of("atletics", "chess", "hockey", "judo")));
        assertThat(result.get("atletics"), is(Set.of("Ivanov")));
        assertThat(result.get("chess"), is(Set.of("Ivanov", "Petrov")));
        assertThat(result.get("hockey"), is(Set.of("Petrov", "Sidorov")));
        assertThat(result.get("judo"), is(Set.of("Ivanov", "Sidorov")));
    }
}