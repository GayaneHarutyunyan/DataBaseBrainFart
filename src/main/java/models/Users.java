package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")

public class Users implements Serializable {

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



  /*
      @OneToMany(fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "usersById")
    private Set<TestSession> testSessionsById;

*/


}
