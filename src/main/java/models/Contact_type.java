package models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "contact_type")
public class Contact_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    @OneToOne(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private Contacts contacts_type;


    public Contact_type(){}

    public Contact_type(String type){
        this.type = type;
    }

    public int getId(){
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
