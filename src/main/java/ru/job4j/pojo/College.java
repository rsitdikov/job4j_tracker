package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan Ivanov");
        student.setGroup("A-50");
        student.setDate(LocalDate.of(2019, 9, 1));
        System.out.println("Student " + student.getName() + " was accepted to the "
                            + student.getGroup() + " group on " + student.getDate());
    }
}
