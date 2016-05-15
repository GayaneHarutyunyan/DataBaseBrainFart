package modelAdmin;

import modelAdmin.Admins;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
public class Powers {

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
