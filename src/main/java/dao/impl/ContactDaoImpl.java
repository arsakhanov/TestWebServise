package dao.impl;

import dao.ContactDao;
import models.Contact;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ContactDaoImpl implements ContactDao {

    public Contact findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contact.class, id);
    }

    public List<Contact> findAll() {
        List<Contact> contacts = (List<Contact>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From " + Contact.class.getSimpleName()).list();
        return contacts;
    }

    public void save(Contact contact) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(contact);
        tx.commit();
        session.close();
    }

    public void update(Contact contact) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(contact);
        tx.commit();
        session.close();
    }

    public void delete(int id) {
        Contact contact;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        contact = session.load(Contact.class, id);
        session.delete(contact);
        tx.commit();
        session.close();
    }
}
