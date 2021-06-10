package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int count = left.length() < right.length() ? left.length() : right.length();
        int rsl = 0;
        for (int index = 0; index < count; index++) {
            rsl = Character.compare(left.charAt(index), right.charAt(index));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0 && left.length() != right.length()) {
            rsl = left.length() < right.length() ? -1 : 1;
        }
        return rsl;
    }

}