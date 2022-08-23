package ru.job4j.early;

import java.util.function.Predicate;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password not set.");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password length must be at least 8 and not more than 32 characters.");
        }
        if (isStopList(password)) {
            throw new IllegalArgumentException("Password must not contain 'qwerty', '12345', 'password', 'admin', 'user'.");
        }
        if (!checkSymbols(password, Character::isUpperCase)) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }
        if (!checkSymbols(password, Character::isLowerCase)) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter.");
        }
        if (!checkSymbols(password, Character::isDigit)) {
            throw new IllegalArgumentException("Password must contain at least one digit.");
        }
        if (!checkSymbols(password, character -> !Character.isLetterOrDigit(character))) {
            throw new IllegalArgumentException("Password must contain at least one special character.");
        }
        return "Good password.";
    }

    private static boolean isStopList(String text) {
        boolean rsl = false;
        String[] stop = {"qwerty", "12345", "password", "admin", "user"};
        String first = text.toLowerCase();
        for (String second : stop) {
            if (first.contains(second)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static boolean checkSymbols(String text, Predicate<Character> predicate) {
        boolean rsl = false;
        for (Character character : text.toCharArray()) {
            if (predicate.test(character)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
