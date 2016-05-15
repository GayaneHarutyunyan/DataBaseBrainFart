package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "Subjects")
public class Subjects implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "subject")
    private String subject;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subjectId")
    private Set<Tests> testses;
}
