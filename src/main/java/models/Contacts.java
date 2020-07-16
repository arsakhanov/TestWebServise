package models;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table (name = "contacts")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_type_id")
    private Contact_type type;

    public Contacts(){}

    public Contacts(String number){
        this.number = number;
    }
    public int getId(){
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String  number) {
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
