package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SortIncreaseByItemNameTest {

    @Test
    public void whenTheOrderSecondThirdFirst() {
        Item first = new Item("5");
        Item second = new Item("3");
        Item third = new Item("4");
        first.setId(0);
        second.setId(0);
        third.setId(0);
        List<Item> items = Arrays.asList(first, second, third);
        List<Item> expected = Arrays.asList(second, third, first);
        Collections.sort(items, new SortIncreaseByItemName());
        assertThat(expected, is(items));
    }
}