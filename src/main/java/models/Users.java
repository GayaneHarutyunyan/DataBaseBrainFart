package models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Users")
@Getter
@Setter
//@NoArgsConstructor

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
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

    @Transient
    @OneToMany(mappedBy = "usersByUserId")
    private Set<TestSession> testSessionsById = new HashSet<>();

    public Users(String firstName, String secondName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Users(Integer id, Set<TestSession> testSessionsById) {
        this.id = id;
        this.testSessionsById = testSessionsById;
    }


    public Users() {
    }
}
