package ru.job4j.oop.profession;

public class Building {
    private String name;
    private String material;
    private int floors;
    private String location;

    public Building(String name, String material, int floors, String location) {
        this.name = name;
        this.material = material;
        this.floors = floors;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
