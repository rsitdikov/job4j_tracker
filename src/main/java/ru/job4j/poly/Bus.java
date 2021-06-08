package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("The bus is going.");
    }

    @Override
    public void passengers(int count) {
        System.out.println(count + "passanger(s) in the cabin.");
    }

    @Override
    public double refuel(int gas) {
        double price = 43.50;
        return gas * price;
    }
}
