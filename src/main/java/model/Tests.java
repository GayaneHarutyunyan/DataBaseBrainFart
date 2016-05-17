package model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Tests")
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
//@ToString(doNotUseGetters = true)
//@EqualsAndHashCode(doNotUseGetters = true)

public class Tests implements Serializable {

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

    @Lob
    @Basic(fetch = FetchType.LAZY)
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

    public Tests( String description, String name, boolean publicity) {
        this.description = description;
        this.name = name;
        this.publicity = publicity;
    }

}
