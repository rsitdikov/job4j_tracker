package ru.job4j.stream;

public class Car {
    private String manufacturer;
    private String model;
    private String color;
    private short power;
    private short year;
    private int mileage;
    private byte owners;
    private int price;

    static class Builder {
        private String manufacturer;
        private String model;
        private String color;
        private short power;
        private short year;
        private int mileage;
        private byte owners;
        private int price;

        Builder buildManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildPower(short power) {
            this.power = power;
            return this;
        }

        Builder buildYear(short year) {
            this.year = year;
            return this;
        }

        Builder buildMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        Builder buildOwners(byte owners) {
            this.owners = owners;
            return this;
        }

        Builder buildPrice(int price) {
            this.price = price;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.manufacturer = manufacturer;
            car.model = model;
            car.color = color;
            car.power = power;
            car.year = year;
            car.mileage = mileage;
            car.owners = owners;
            car.price = price;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "manufacturer='" + manufacturer + '\''
                + ", model='" + model + '\''
                + ", color='" + color + '\''
                + ", power=" + power
                + ", year=" + year
                + ", mileage=" + mileage
                + ", owners=" + owners
                + ", price=" + price
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder().buildManufacturer("Ford")
                .buildModel("Kuga")
                .buildColor("Black")
                .buildPower((short) 150)
                .buildYear((short) 2017)
                .buildMileage(85000)
                .buildOwners((byte) 3)
                .buildPrice(1250000)
                .build();
        System.out.println(car);

    }
}
