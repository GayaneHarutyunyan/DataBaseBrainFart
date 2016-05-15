package models;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter

public class Users extends Model {

    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "second_name")
    private String secondName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "usersByUserId")
    private Set<TestSession> testSessionsById;


    public Users() {
        super();
    }

    public Users(Integer id) {
        super(id);
    }




}
