package ru.job4j.poly;

public class UsagePoly {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Bus("Man"), new Plane("Boeing-737"),
                new Train("Royal Scotsman"), new Train("Royal Rajasthan on Wheels"),
                new Plane("Airbus-A320"), new Bus("Citroen Jumper III")};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
