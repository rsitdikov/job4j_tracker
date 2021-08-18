package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> namePredicate = person -> person.getName().contains(key);
        Predicate<Person> surnamePredicate = person -> person.getSurname().contains(key);
        Predicate<Person> addressPredicate = person -> person.getAddress().contains(key);
        Predicate<Person> phonePredicate = person -> person.getPhone().contains(key);
        Predicate<Person> combine = namePredicate.or(surnamePredicate)
                .or(addressPredicate).or(phonePredicate);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
