import models.Contacts;
import models.Person;
import services.PersonService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        PersonService personService = new PersonService();
        Person person = new Person("Иван", "Ивановов", "Ваня", "3");
        personService.savePerson(person);
        Contacts contact1 = new Contacts("89876543210");
        contact1.setPerson(person);
        person.addNumber(contact1);
        Contacts contact2 = new Contacts("89876543211");
        contact2.setPerson(person);
        person.addNumber(contact2);
        personService.updatePerson(person);


        Person person1 = new Person("Николай", "Сильный", "Коля", "1");
        personService.savePerson(person1);
        Contacts contact3 = new Contacts("89876543212");
        contact3.setPerson(person1);
        person1.addNumber(contact3);
        personService.updatePerson(person1);
    }
}
