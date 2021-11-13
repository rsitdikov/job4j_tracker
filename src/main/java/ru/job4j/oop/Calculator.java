package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y)
                + multiply(y)
                + minus(y)
                + divide(y);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int sum = sum(10);
        int multiply = calc.multiply(5);
        int minus = minus(10);
        int divide = calc.divide(5);
        int all = calc.sumAllOperation(12);
    }
}