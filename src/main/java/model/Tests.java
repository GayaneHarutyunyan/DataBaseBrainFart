package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "Tests")
public class Tests implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Basic
    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "subject_id", nullable = false)
    @NotNull
    private Subjects subjectId;

    @Basic
    @NotNull
    @Column(name = "description")
    private String description;

    @Basic
    @NotNull
    @Column(name = "publicity")
    private boolean publicity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "testsId")
    private Set<QuestionConnections> questionConnectionses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "testId")
    private Set<TestAvailability> testAvailabilityes;


}
