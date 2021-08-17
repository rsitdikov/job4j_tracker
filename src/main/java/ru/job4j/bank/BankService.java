package ru.job4j.bank;

import java.util.*;

/**
 *  Класс описывает модель банковской системы.
 *  В системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *  @author RAMIL SITDIKOV
 *  @version 1.0
 */
public class BankService {
    /**
     * Данные о пользователях банка храняться в коллекции типа HashMap, где ключами являются
     * объекты типа User, а значениями - списки счетов
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему. На входе - объект типа {@link User}.
     * Если в коллекции users нет заданного объекта, он добавляется с пустым
     * списком счетов.
     * @param user новый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю, если пользователь найден по
     * паспорту и у пользователя нет заданного номера счета.
     * Метод принимает на вход номер паспорта пользователя и новый номер счета.
     * @param passport номер паспорта пользователя
     * @param account новый номер счета
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && users.get(user.get()).indexOf(account) == -1) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод выполняет поиск пользователя по номеру паспорта.
     * На входе метода - номер паспорта пользователя.
     * Метод возвращает объект Optional<User>
     * @param passport номер паспорта пользователя
     * @return  объект  {@code Optional<User>}
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод выполняет поиск счета пользователя по реквизитам.
     * На входе метода - номер паспорта пользователя и реквизиты счета.
     * Метод возвращает объект Optional<Account>
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return объект {@code Optional<Account>}
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport)
                .flatMap(u -> users.get(u)
                        .stream()
                        .filter(a -> a.getRequisite().equals(requisite))
                        .findFirst()
                );
    }

    /**
     * Метод выполняет перечисление средств с одного счета на другой.
     * Принимает на вход: номер паспорта отправителя, реквизиты счета отправителя,
     * номер паспорта получателя, реквизиты счета получателя, перечисляемая сумма
     * денежных средств.
     * Возвращает {@code true}, если перечисление выполнено, иначе - {@code false}
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport номер паспорта полчателя
     * @param destRequisite реквизиты счета получателя
     * @param amount сумма к перечислению
     * @return {@code true}, если перечисление выполнено, иначе - {@code false}
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            rsl = true;
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
        }
        return rsl;
    }
}