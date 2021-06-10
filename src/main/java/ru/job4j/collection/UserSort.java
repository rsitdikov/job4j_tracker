package ru.job4j.collection;

import java.util.Comparator;

public class UserSort {

    static class UserSortByName implements Comparator<User> {

        @Override
        public int compare(User first, User second) {
            return first.getName().compareTo(second.getName());
        }
    }

    static class UserSortByNameReverse implements Comparator<User> {

        @Override
        public int compare(User first, User second) {
            return second.getName().compareTo(first.getName());
        }
    }

    static class UserSortByAge implements Comparator<User> {

        @Override
        public int compare(User first, User second) {
            return Integer.compare(first.getAge(), second.getAge());
        }
    }

    static class UserSortAgeReverse implements Comparator<User> {

        @Override
        public int compare(User first, User second) {
            return Integer.compare(second.getAge(), first.getAge());
        }
    }
}

