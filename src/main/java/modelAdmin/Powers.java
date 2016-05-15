package modelAdmin;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;


@Entity
public class Powers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Basic
    @NotNull
    @Column(name = "position")
    private String position;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "powersId")
    private Set<Admins> admin;

}
