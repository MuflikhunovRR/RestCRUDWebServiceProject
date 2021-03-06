package ru.gotoqa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gotoqa.dao.PersonDao;
import ru.gotoqa.model.Person;

import java.util.List;

/**
 * @author Muflikhunov Roman
 */

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        this.personDao.addPerson(person);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        this.personDao.removePerson(id);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        this.personDao.updatePerson(person);
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return this.personDao.getPersonById(id);
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDao.listPersons();
    }
}
