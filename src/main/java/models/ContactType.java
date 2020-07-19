package models;


import javax.persistence.*;
import java.util.List;

/**
 * Класс-сущность описывает модель таблицы contact_type в базе данных
 */

@Entity
@Table(name = "contact_type")
public class ContactType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contactsType;

    public List<Contact> getContactsType() {
        return contactsType;
    }


    public void setContactsType(List<Contact> contactsType) {
        this.contactsType = contactsType;
    }

    public ContactType() {
    }

    public ContactType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
