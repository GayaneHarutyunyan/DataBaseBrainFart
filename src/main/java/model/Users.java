package model;


import lombok.*;
import lombok.experimental.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)

public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "second_name")
    private String secondName;

    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "{invalid.email}")
    @NotNull
    @Column(name = "email")
    protected String email;

    @Pattern.List({
            @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
                    message = "{invalid.phone_number} ( ххх ) ххх - хххх"),
            @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
                    message = "{invalid.home_number} ( ххх ) ххх - хххх")
    })
    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
    private Set<TestSession> testSession;
}
