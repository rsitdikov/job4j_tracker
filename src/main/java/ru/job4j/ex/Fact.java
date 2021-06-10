package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        for (int i = 10; i > -2; i--) {
            System.out.println("number: " + i + " factorial: " + new Fact().calc(i));
        }
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
