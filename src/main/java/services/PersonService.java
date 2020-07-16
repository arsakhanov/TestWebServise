package services;

import dao.PersonDao;
import dao.Dao;
import models.Contacts;
import models.Person;

import java.util.List;

public class PersonService {

    Dao personDao = new PersonDao();

    public PersonService(){}

    public Contacts findContact(int id){
        return personDao.findContactById(id);
    }

    public Person findPerson(int id){
        return personDao.findById(id);
    }

    public void savePerson(Person person){
        personDao.save(person);
    }

    public void updatePerson(Person person){
        personDao.update(person);
    }

    public void deletePerson(Person person){
        personDao.delete(person);
    }

    public List<Person> findAllPerson(){
        return personDao.findAll();
    }

}
