package ru.gotoqa.service;

import ru.gotoqa.model.Person;

import java.util.List;

/**
 * @author Muflikhunov Roman
 */

public interface PersonService {
    public void addPerson(Person person);
    public void removePerson(int id);
    public void updatePerson(Person person);
    public Person getPersonById(int id);
    public List<Person> listPersons();
}
