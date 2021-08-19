package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenConvertMatrixThenResultList() {
        Integer[][] value = {
                {2, 4, 6},
                {8, 10, 12},
                {14, 16, 18}
        };
        List<Integer> expected = List.of(2, 4, 6, 8, 10, 12, 14, 16, 18);
        assertThat(new Matrix().convertToList(value), is(expected));
    }
}