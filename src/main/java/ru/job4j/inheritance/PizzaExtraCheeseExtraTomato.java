package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {

    @Override
    public String name() {
        return String.join(" + ", super.name(), "extra tomato");
    }
}
