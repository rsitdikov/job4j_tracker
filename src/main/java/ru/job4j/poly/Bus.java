package ru.job4j.poly;

public class Bus implements Vehicle {
    private String name;

    public Bus(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " '" + name
                + "' передвигается по скоростным трассам.");
    }
}
