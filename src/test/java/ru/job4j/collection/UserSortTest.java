package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserSortTest {
    @Test
    public void whenNamesAscendingOrder() {
        User ivan = new User("Ivan", 35);
        User petr = new User("Petr", 32);
        User roman = new User("Roman", 37);
        User anatoly = new User("Anatoly", 39);
        List<User> users = Arrays.asList(ivan, petr, roman, anatoly);
        List<User> expect = Arrays.asList(anatoly, ivan, petr, roman);
        users.sort(new UserSort.UserSortByName());
        assertThat(users, is(expect));
    }

    @Test
    public void whenNamesDescendingOrder() {
        User ivan = new User("Ivan", 35);
        User petr = new User("Petr", 32);
        User roman = new User("Roman", 37);
        User anatoly = new User("Anatoly", 39);
        List<User> users = Arrays.asList(ivan, petr, roman, anatoly);
        List<User> expect = Arrays.asList(roman, petr, ivan, anatoly);
        users.sort(new UserSort.UserSortByNameReverse());
        assertThat(users, is(expect));
    }

    @Test
    public void whenAgeAscendingOrder() {
        User ivan = new User("Ivan", 35);
        User petr = new User("Petr", 32);
        User roman = new User("Roman", 37);
        User anatoly = new User("Anatoly", 39);
        List<User> users = Arrays.asList(ivan, petr, roman, anatoly);
        List<User> expect = Arrays.asList(petr, ivan, roman, anatoly);
        users.sort(new UserSort.UserSortByAge());
        assertThat(users, is(expect));
    }

    @Test
    public void whenAgeDescendingOrder() {
        User ivan = new User("Ivan", 35);
        User petr = new User("Petr", 32);
        User roman = new User("Roman", 37);
        User anatoly = new User("Anatoly", 39);
        List<User> users = Arrays.asList(ivan, petr, roman, anatoly);
        List<User> expect = Arrays.asList(anatoly, roman, ivan, petr);
        users.sort(new UserSort.UserSortAgeReverse());
        assertThat(users, is(expect));
    }

    @Test
    public void whenCompatorByNameAndAge() {
        Comparator<User> cmpNameAge = new UserSort.UserSortByName().thenComparing(new UserSort.UserSortByAge());
        int rsl = cmpNameAge.compare(
                new User("A", 1),
                new User("B", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndAgeReverse() {
        Comparator<User> cmpNameAge = new UserSort.UserSortByName().thenComparing(new UserSort.UserSortAgeReverse());
        int rsl = cmpNameAge.compare(
                new User("A", 1),
                new User("B", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameReverseAndAge() {
        Comparator<User> cmpNameAge = new UserSort.UserSortByNameReverse().thenComparing(new UserSort.UserSortByAge());
        int rsl = cmpNameAge.compare(
                new User("A", 1),
                new User("B", 0)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenCompatorByNameReverseAndAgeReverse() {
        Comparator<User> cmpNameAge = new UserSort.UserSortByNameReverse().thenComparing(new UserSort.UserSortAgeReverse());
        int rsl = cmpNameAge.compare(
                new User("A", 1),
                new User("B", 0)
        );
        assertThat(rsl, is(1));
    }
}
