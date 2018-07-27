package ru.gotoqa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gotoqa.model.Person;

import java.util.List;

/**
 * @author Muflikhunov Roman
 */
public class PersonDaoImpl implements PersonDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDaoImpl.class);

    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
        LOGGER.info("Person add. " + person);
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));

        if(person!=null){
            session.delete(person);
        }
        LOGGER.info("Person removed. " + person);
    }

    @Override
    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
        LOGGER.info("Person update. " + person);
    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        LOGGER.info("Person upload. " + person);

        return person;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("from Person").list();

        for(Person person : personList){
            LOGGER.info("Persons: " + person);
        }

        return personList;
        }
}
