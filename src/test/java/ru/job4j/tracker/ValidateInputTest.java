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
                new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"});
        ValidateInput input = new ValidateInput(out, in);
        for (int expected = 0; expected <= 9; expected++) {
            int selected = input.askInt("Enter menu:");
            assertThat(selected, is(expected));
        }
    }

    @Test
    public void whenInputNegative() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-5", "5"}
        );
        ValidateInput input = new ValidateInput(out, in);
        input.askInt("Enter menu:");
        assertThat(out.toString(), is ("Please enter validate data again."
        + System.lineSeparator()));
    }
}