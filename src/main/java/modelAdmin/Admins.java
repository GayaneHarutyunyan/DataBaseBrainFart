package modelAdmin;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Entity
@Table(name = "Admins")
@Accessors(chain = true)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Admins implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "{invalid.email}")
    @NotNull
    @Column(name = "email")
    private String email;

    @Basic
    @NotNull
    @Column(name = "password")
    private String password;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "powers_id", nullable = false)
    @NotNull
    private Powers powersId;

    public Admins(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
