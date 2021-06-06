package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
        active = false;
        status = 0;
        message = "Not error";
    }

    public  Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void info() {
        System.out.println("--------------------");
        System.out.println("Info:");
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("massage: " + message);
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(true, 1, "Input error");
        Error third = new Error(true, 2, "Output error");
        Error four = new Error(false, 0, "Not error");
        first.info();
        second.info();
        third.info();
        four.info();
    }
}
