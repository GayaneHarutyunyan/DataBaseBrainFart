package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @NotNull
    @Column(name = "second_name")
    private String secondName;

    @Basic
    @NotNull
    @Column(name = "email")
    private String email;

    @Basic
    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
    private Set<TestSession> testSession;
}
