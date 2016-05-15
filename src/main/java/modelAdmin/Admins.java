package modelAdmin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
public class Admins implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Basic
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


}
