package modelAdmin;


import lombok.*;
import lombok.experimental.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Powers")
@Accessors(chain = true)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

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
    private List<Admins> admin = new ArrayList<>();

}
