package ru.job4j.oop;

public class Student extends Object {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        int count = 3;
        for (int i = 0; i < count; i++) {
            petya.music();
        }
        for (int i = 0; i < count; i++) {
            petya.song();
        }
    }
}