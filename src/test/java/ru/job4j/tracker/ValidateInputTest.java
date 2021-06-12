package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"5"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(5));
    }

    @Test
    public void whenMultiValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "1000"});
        ValidateInput input = new ValidateInput(out, in);
        assertThat(input.askInt("Enter menu:"), is(0));
        assertThat(input.askInt("Enter menu:"), is(1));
        assertThat(input.askInt("Enter menu:"), is(2));
        assertThat(input.askInt("Enter menu:"), is(3));
        assertThat(input.askInt("Enter menu:"), is(4));
        assertThat(input.askInt("Enter menu:"), is(5));
        assertThat(input.askInt("Enter menu:"), is(6));
        assertThat(input.askInt("Enter menu:"), is(7));
        assertThat(input.askInt("Enter menu:"), is(8));
        assertThat(input.askInt("Enter menu:"), is(1000));
    }

    @Test
    public void whenInputNegative() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-5"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-5));
    }
}