
import dao.ContactDao;
import dao.impl.ContactDaoImpl;
import models.Contact;
import models.ContactType;
import models.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContactDaoTest {

   private ContactDao contactDao = new ContactDaoImpl();
   private int testContactId;

   public void setTestContactId(int testContactId){
       this.testContactId = testContactId;
   }

   public int getTestContactId(){
       return testContactId;
   }

    @Before
    public void initTest() {
        Person person = new Person("Test", "Testov", "Testovich", "Testing");
        ContactType contactType = new ContactType("Test worker");
        Contact contact = new Contact("1111111111");
        contact.setPerson(person);
        contact.setType(contactType);
        contactDao.save(contact);
        setTestContactId(contact.getId());
    }

    @Test
    public void testAddContact() {
        Person person = new Person("Mikhail", "Gromov", "Vladimirovich", "Junior java developer");
        ContactType contactType = new ContactType("programmer");
        Contact contact = new Contact("654321987");
        contact.setPerson(person);
        contact.setType(contactType);
        contactDao.save(contact);

        Assert.assertNotNull(contact);
    }

    @Test
    public void testDeleteContact() {
        contactDao.delete(getTestContactId());
    }

    @Test
    public void testUpdateContact() {
        Contact contact;
        contact = contactDao.findById(25);
        Person person = new Person("Changed firstname", "Changed lastname", "Changed middlename", "Changed position");
        ContactType contactType = new ContactType("Changed type");
        contact.setPerson(person);
        contact.setType(contactType);
        contactDao.update(contact);
    }

    @Test
    public void testFindById() {
        Contact contact = contactDao.findById(getTestContactId());
        Assert.assertNotNull(contact);
        Assert.assertEquals(getTestContactId(), contact.getId());
    }

    @Test
    public void testFinfAll(){
        contactDao.findAll();
    }

    @After
    public void uninitTest(){
        contactDao.delete(getTestContactId());
    }
}
