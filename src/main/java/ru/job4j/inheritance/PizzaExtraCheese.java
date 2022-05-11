package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {

    @Override
    public String name() {
        return String.join(" + ", super.name(), "extra cheese");
    }
}
