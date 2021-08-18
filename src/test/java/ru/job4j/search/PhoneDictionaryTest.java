package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Sidorov", "1234567", "Moscow")
        );
        var persons = phones.find("Ivan");
        assertThat(persons.get(0).getSurname(), is("Sidorov"));
    }

    @Test
    public void whenFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Sidorov", "1234567", "Moscow")
        );
        var persons = phones.find("Sidorov");
        assertThat(persons.get(0).getName(), is("Ivan"));
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Sidorov", "1234567", "Moscow")
        );
        var persons = phones.find("1234567");
        assertThat(persons.get(0).getSurname(), is("Sidorov"));
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Sidorov", "1234567", "Moscow")
        );
        var persons = phones.find("Moscow");
        assertThat(persons.get(0).getSurname(), is("Sidorov"));
    }
}