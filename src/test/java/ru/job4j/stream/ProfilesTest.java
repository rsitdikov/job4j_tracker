package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenFourProfilesThenFourSortedAddresses() {
        Address first = new Address("Perm", "Lenina", 20, 5);
        Address second = new Address("Ekaterinburg", "Malysheva", 60, 41);
        Address third = new Address("Izhevsk", "Pushkinskaya", 116, 101);
        Address four = new Address("Kirov", "Kalinina", 51, 15);
        List<Address> expected = List.of(second, third, four, first);
        List<Profile> clients = List.of(
                new Profile(first),
                new Profile(second),
                new Profile(third),
                new Profile(four));
        List<Address> result = new Profiles().collect(clients);
        assertThat(result, is(expected));
    }
    @Test
    public void whenProfilesAreRepeatedThenResultIsUnique() {
        Address first = new Address("Perm", "Lenina", 20, 5);
        Address second = new Address("Ekaterinburg", "Malysheva", 60, 41);
        Address third = new Address("Izhevsk", "Pushkinskaya", 116, 101);
        Address four = new Address("Kirov", "Kalinina", 51, 15);
        Address five = new Address("Ekaterinburg", "Malysheva", 60, 41);
        Address six = new Address("Kirov", "Kalinina", 51, 15);
        List<Address> expected = List.of(second, third, four, first);
        List<Profile> clients = List.of(
                new Profile(first),
                new Profile(second),
                new Profile(third),
                new Profile(four),
                new Profile(five),
                new Profile(six));
        List<Address> result = new Profiles().collect(clients);
        assertThat(result, is(expected));
    }
}
