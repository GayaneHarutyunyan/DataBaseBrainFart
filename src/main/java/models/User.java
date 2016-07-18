package models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "user")
@AllArgsConstructor
@Getter
@Setter
public class User extends Model {

    @Size(min = 5, max = 25)
    @NotNull
    @Column(name = "first_name", length = 25)
    private String firstName;

    @Size(min = 5, max = 50)
    @NotNull
    @Column(name = "second_name", length = 50)
    private String secondName;

    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "{invalid.email}")
    @NotNull
    @Column(name = "email")
    protected String email;

    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message = "{invalid.phone_number} ( ххх ) ххх - хххх")
    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TestSession> testSession = new HashSet<>();

    public User() {
        super();
    }

    public User(Long id) {
        super(id);
    }

    public User(String firstName, String secondName, String phoneNumber, String email) {
        super();
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}