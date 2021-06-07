package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book martin = new Book("Clean Code", 464);
        Book goetz = new Book("Java Concurrency in Practice", 384);
        Book lafore = new Book("Data Structures & Algorithms in Java", 704);
        Book eckel = new Book("Thinking in Java", 1168);
        Book[] lib = new Book[4];
        lib[0] = martin;
        lib[1] = goetz;
        lib[2] = lafore;
        lib[3] = eckel;
        for (int index = 0; index < lib.length; index++) {
            System.out.println("Book title: " + lib[index].getName()
                    + ", number of pages: " + lib[index].getPages());
        }
        System.out.println();
        Book tmp = lib[0];
        lib[0] = lib[3];
        lib[3] = tmp;
        for (int index = 0; index < lib.length; index++) {
            System.out.println("Book title: " + lib[index].getName()
                    + ", number of pages: " + lib[index].getPages());
        }
        System.out.println();
        String request = "Clean Code";
        for (int index = 0; index < lib.length; index++) {
            if (lib[index].getName().equals(request)) {
                System.out.println("Book title: " + lib[index].getName()
                        + ", number of pages: " + lib[index].getPages()
                        + ", library index: " + index);
            }
        }
    }
}

