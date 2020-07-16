package dao;


import models.Contacts;
import models.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class PersonDao implements Dao {

    public Contacts findContactById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contacts.class, id);
    }

    public Person findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Person.class, id);
    }

    public List<Person> findAll() {
        List<Person> persons = (List<Person>)   HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From" + Contacts.class.getSimpleName()).list();
        return persons;
    }

    public void save(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    public void delete(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(person);
        tx1.commit();
        session.close();
    }
}
