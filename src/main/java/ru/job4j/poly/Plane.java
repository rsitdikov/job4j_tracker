package ru.job4j.poly;

public class Plane implements Vehicle {
    private String name;

    public Plane(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " '" + name + "' летает по вохдуху.");
    }
}
