package models;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table (name = "contacts")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_type_id")
    private Contact_type type;


    public int getId(){
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contact_type getType() {
        return type;
    }

    public void setType(Contact_type type) {
        this.type = type;
    }


}
