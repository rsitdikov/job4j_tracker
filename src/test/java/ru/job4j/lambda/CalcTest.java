package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CalcTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calc calc = new Calc();
        List<Double> result = calc.diapason(1, 6, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(3D, 5D, 7D, 9D, 11D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        Calc calc = new Calc();
        List<Double> result = calc.diapason(1, 6, x -> x * x + 5);
        List<Double> expected = Arrays.asList(6D, 9D, 14D, 21D, 30D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        Calc calc = new Calc();
        List<Double> result = calc.diapason(1, 6, x -> Math.log(x));
        List<Double> expected = Arrays.asList(Math.log(1), Math.log(2), Math.log(3), Math.log(4), Math.log(5));
        assertThat(result, is(expected));
    }
} 