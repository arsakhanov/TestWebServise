package services;

import dao.ContactDao;
import dao.impl.ContactDaoImpl;
import models.Contact;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ContactEndpoint {

    ContactDao contactDao = new ContactDaoImpl();

    @WebMethod
    public void addContact(Contact contact) {
        contactDao.save(contact);
    }

    @WebMethod
    public void deleteContact(int id) {
        contactDao.delete(id);
    }

    @WebMethod
    public void updateContact(Contact contact) {
        contactDao.update(contact);
    }
}
