package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUIOld {
    public static void main(String[] args) {
        Item first = new Item("first item");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String created = first.getCreated().format(formatter);
        System.out.println(created);
        Tracker tracker = new Tracker();
        tracker.add(new Item ("second item"));
        Item second = tracker.findById(1);
        System.out.println(second.getName());
        Item third = new Item ("third item", 100500);
        System.out.println(third);
    }
}

