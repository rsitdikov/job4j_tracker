package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("The number cannot be negative");
        }
        return n > 1 ? calc(n - 1) * n : 1;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}
