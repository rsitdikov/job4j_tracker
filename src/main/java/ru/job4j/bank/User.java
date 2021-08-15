package ru.job4j.bank;

import java.util.Objects;

/**
 *  Класс описывает модель пользователя
 *  @author RAMIL SITDIKOV
 *  @version 1.0
 */
public class User {
    /**
     * Номер паспорта
     */
    private String passport;
    /**
     * ФИО пользователя
     */
    private String username;

    /**
     * Конструктор - создание нового пользователя с определенными значениями
     * @param passport номер паспорта
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает номер паспорта пользователя
     * @return passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает на вход номер паспорта пользователя
     * и записывает его в поле passport
     * @param passport номер паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает имя пользователя
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает на вход имя пользователя и
     * записывает его в поле username
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод переопределяет метод {@link Object#equals(Object)}
     * @param o объект класса {@link #User(String, String)}
     * @return возвращает {@code true} если объекты равны,
     * иначе {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод переопределяет метод {@link Object#hashCode()}
     * @return возвращает хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}