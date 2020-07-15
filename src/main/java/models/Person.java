package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String position;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contacts> contacts;

    public void addNumber(Contacts contact){
        contact.setPerson(this);
        contacts.add(contact);
    }

    public void removeNumber(Contacts contact){
        contacts.remove(contact);
    }

    public Person(){}

    public Person(String first_name, String last_name, String middle_name, String position){
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.position = position;
        contacts = new ArrayList<Contacts>();
    }

    public int getId(){
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Contacts> getNumbers() {
        return contacts;
    }

    public void setNumbers(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
