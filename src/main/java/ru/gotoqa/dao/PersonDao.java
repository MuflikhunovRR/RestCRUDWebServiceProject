package ru.gotoqa.dao;

import ru.gotoqa.model.Person;

import java.util.List;

/**
 * @author Muflikhunov Roman
 */
public interface PersonDao {
    public void addPerson(Person person);
    public void removePerson(int id);
    public void updatePerson(Person person);
    public Person getPersonById(int id);
    public List<Person> listPersons();
}
