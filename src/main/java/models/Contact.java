package models;

import javax.persistence.*;

/**
 * Класс-сущность описывает модель таблицы contacts в базе данных
 */

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    //зависимость вида многие к одному
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    //указываем поля для многие к одному
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "contact_type_id")
    private ContactType type;

    public Contact() {
    }

    public Contact(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }


}
