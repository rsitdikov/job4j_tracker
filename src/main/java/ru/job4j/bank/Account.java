package ru.job4j.bank;

import java.util.Objects;

/**
 *  Класс описывает модель банковского счета.
 *  @author RAMIL SITDIKOV
 *  @version 1.0
 */
public class Account {
    /**
     * Реквизиты банковского счета
     */
    private String requisite;
    /**
     * Баланс банковского счета
     */
    private double balance;

    /**
     * Конструктор - создание нового счета с определенными значениями
     * @param requisite реквизиты счета
     * @param balance баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает реквизиты банковского счета.
     * @return requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает на вход реквизиты банковского счета
     * и записывает их в поле requisite
     * @param requisite реквизиты банковского счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает баланс банковского счета.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает на вход баланс банковского счета
     * и записывает его в поле balance
     * @param balance баланс банковского счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод переопределяет метод {@link Object#equals(Object)}
     * @param o объект класса {@link #Account(String, double)}
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод переопределяет метод {@link Object#hashCode()}
     * @return возвращает хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}