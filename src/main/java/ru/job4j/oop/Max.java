package ru.job4j.oop;

public class Max {
    public int max(int left, int right) {
        int result = (left > right) ? left : right;
        return result;
    }

    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public int max(int first, int second, int third, int four) {
        return max(first, max(second, max(third, four)));
    }
}
