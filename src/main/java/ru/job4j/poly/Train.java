package ru.job4j.poly;

public class Train implements Vehicle {
    private String name;

    public Train(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " '"
                + name + "' передвигается по рельсам.");
    }
}
