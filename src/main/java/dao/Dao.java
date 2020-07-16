package dao;

import models.Contacts;
import models.Person;

import java.util.List;

public interface Dao {

    public Person findById(int id);

    public Contacts findContactById(int id);

    List<Person> findAll();

    public void save(Person person);

    public void update(Person person);

    public void delete(Person person);
}
